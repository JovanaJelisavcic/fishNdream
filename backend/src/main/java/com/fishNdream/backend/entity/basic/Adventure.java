package com.fishNdream.backend.entity.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.helper.AdditionalServicesAdventure;
import com.fishNdream.backend.entity.helper.AvailabilityPeriodAdventures;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;

@Entity
public class Adventure {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.UnauthoInstuctors.class)
	private int adventureId;
	@JsonView(Views.UnauthoInstuctors.class)
	private String name;
	@JsonView(Views.UnauthoInstuctors.class)
	private float price;
	@JsonView(Views.UnauthoInstuctors.class)
	private String address;
	@JsonView(Views.UnauthoInstuctors.class)
	private String description;
	@JsonView(Views.AdventureInfo.class)
	private int maxParticipants;
	@JsonView(Views.AdventureInfo.class)
	private String behaviourRules;
	@JsonView(Views.AdventureInfo.class)
	private boolean cancelPolicy; // 0-free
	@ManyToOne

	private Instructor instructor;
	@OneToMany(
	        mappedBy = "adventure",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<AvailabilityPeriodAdventures> availablePeriods;
	@OneToMany(
	        mappedBy = "adventure",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ReservationAdventure> reservations;
	
	@OneToMany(
	        mappedBy = "adventure",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<AdditionalServicesAdventure> additionalServices;
	@ElementCollection
	@CollectionTable(name = "adventure_pics", joinColumns = @JoinColumn(name = "adventure_id"))
	@JsonView(Views.UnauthoInstuctors.class)
	private Set<String> adventurePics = new HashSet<>();
	
	public List<ReservationAdventure> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationAdventure> reservations) {
		this.reservations = reservations;
	}

	public List<AdditionalServicesAdventure> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServicesAdventure> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public List<AvailabilityPeriodAdventures> getAvailablePeriods() {
		return availablePeriods;
	}

	public void setAvailablePeriods(List<AvailabilityPeriodAdventures> availablePeriods) {
		this.availablePeriods = availablePeriods;
	}

	public Adventure() {}
	
	public Adventure(int adventureId, String name, String address, String description, int maxParticipants,
			String behaviourRules, boolean cancelPolicy) {
		super();
		this.adventureId = adventureId;
		this.name = name;
		this.address = address;
		this.description = description;
		this.maxParticipants = maxParticipants;
		this.behaviourRules = behaviourRules;
		this.cancelPolicy = cancelPolicy;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAdventureId() {
		return adventureId;
	}
	public void setAdventureId(int adventureId) {
		this.adventureId = adventureId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxParticipants() {
		return maxParticipants;
	}
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	public String getBehaviourRules() {
		return behaviourRules;
	}
	public void setBehaviourRules(String behaviourRules) {
		this.behaviourRules = behaviourRules;
	}
	public boolean isCancelPolicy() {
		return cancelPolicy;
	}
	public void setCancelPolicy(boolean cancelPolicy) {
		this.cancelPolicy = cancelPolicy;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public boolean isAvailableAndFreeWithInstructor(LocalDateTime from, LocalDateTime to) {
		if(!instructor.isInstructorFree(from,to)) return false;
		if(!isAvailableAndFree(from, to)) return false;
		return true;
		
	}

	public boolean isAvailableAndFree(LocalDateTime from, LocalDateTime to) {
		boolean available =false;
		for(AvailabilityPeriodAdventures period : availablePeriods) {
			if(period.getBeggining().isBefore(from.toLocalDate()) && period.getEnding().isAfter(to.toLocalDate()))
				available=true;			
		}
		if(!available) return false;
		else {
			for(Adventure adventure : instructor.getAdventures()) {
				for(ReservationAdventure reservation : adventure.getReservations()) {
					if(!(      (from.isBefore(reservation.getBeginning()) && to.isBefore(reservation.getBeginning()))    ||     (from.isAfter(reservation.getEnding()) && to.isAfter(reservation.getEnding()))  ) && !reservation.isCanceled() && reservation.getFisherman()!=null)
						return false;
				}
			}
			return true;
		}
	}

	public void addReservation(ReservationAdventure newReservation) {
		reservations.add(newReservation);
		
	}

	public Adventure removeAction(LocalDateTime from, LocalDateTime to) {
		return instructor.removeAction( from,  to);				
	}

	public List<ReservationAdventure> getActiveActions() {
		List<ReservationAdventure> res = new ArrayList<>();
		for(ReservationAdventure reservation : reservations) {
				if(reservation.isActionRes() && reservation.getActionStartTime().isBefore(LocalDateTime.now()) && reservation.getActionEndTime().isAfter(LocalDateTime.now()) && reservation.getFisherman()==null)
					res.add(reservation);
		}
		return res;
	}

	public void changeActionRes(int reservationId, Fisherman fisherman) {
		for(ReservationAdventure reservation : reservations) {
			if(reservation.getReservationId()== reservationId )
				reservation.setFisherman(fisherman);
	}		
		
	}

	public void cancelReservation(int reservationId) {
		for(ReservationAdventure s: reservations) {
			if(s.getReservationId()==reservationId)
				s.setCanceled(true);
		}
		
	}

	public void cancelActionRes(int reservationId) {
		for(ReservationAdventure s: reservations) {
			if(s.getReservationId()==reservationId)
				s.setFisherman(null);
		}
		
	}
	
	
}
