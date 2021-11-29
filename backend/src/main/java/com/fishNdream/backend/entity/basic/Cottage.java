package com.fishNdream.backend.entity.basic;

import java.time.LocalDate;
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
import com.fishNdream.backend.entity.helper.AdditionalServicesCottage;
import com.fishNdream.backend.entity.helper.AvailabilityPeriodCottages;
import com.fishNdream.backend.entity.intercations.ComplaintCottage;
import com.fishNdream.backend.entity.intercations.ReservationCottage;
import com.fishNdream.backend.entity.intercations.SubscriptionCottage;
import com.fishNdream.backend.entity.users.CottageOwner;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class Cottage {
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.UnauthoCottages.class)
	private int cottageId;
	@JsonView(Views.UnauthoCottages.class)
	private String name;
	@JsonView(Views.UnauthoCottages.class)
	private String address;
	@JsonView(Views.UnauthoCottages.class)
	private String description;
	@JsonView(Views.CottageProfile.class)
	private int roomNum;
	@JsonView(Views.CottageProfile.class)
	private int guestsNum;
	@JsonView(Views.CottageProfile.class)
	private String behaviourRules;
	@ElementCollection
	@CollectionTable(name = "cottage_pics", joinColumns = @JoinColumn(name = "cottage_id"))
	@JsonView(Views.CottageProfile.class)
	private Set<String> cottagePics = new HashSet<>();
	@ManyToOne
	@JsonView(Views.CottageProfile.class)
	private CottageOwner owner;
	@OneToMany(
	        mappedBy = "cottage",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<AvailabilityPeriodCottages> availablePeriods;
	@OneToMany(
	        mappedBy = "cottage",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<AdditionalServicesCottage> additionalServices;
	@OneToMany(
	        mappedBy = "cottage",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ReservationCottage> reservations;
	
	@OneToMany(
	        mappedBy = "cottage",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<SubscriptionCottage> subscriptions;
	
	@OneToMany(
	        mappedBy = "cottage",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ComplaintCottage> complaints;
	
	
	public List<ComplaintCottage> getComplaints() {
		return complaints;
	}


	public void setComplaints(List<ComplaintCottage> complaints) {
		this.complaints = complaints;
	}


	public List<AdditionalServicesCottage> getAdditionalServices() {
		return additionalServices;
	}


	public void setAdditionalServices(List<AdditionalServicesCottage> additionalServices) {
		this.additionalServices = additionalServices;
	}


	
	
	public Cottage() {}
	
	
	public List<ReservationCottage> getReservations() {
		return reservations;
	}


	public List<SubscriptionCottage> getSubscriptions() {
		return subscriptions;
	}


	public void setSubscriptions(List<SubscriptionCottage> subscriptions) {
		this.subscriptions = subscriptions;
	}


	public void setReservations(List<ReservationCottage> reservations) {
		this.reservations = reservations;
	}


	public Cottage(int cottageId, String name, String address, String description, int roomNum, String behaviourRules,
			Set<String> cottagePics) {
		super();
		this.cottageId = cottageId;
		this.name = name;
		this.address = address;
		this.description = description;
		this.roomNum = roomNum;
		this.behaviourRules = behaviourRules;
		this.cottagePics = cottagePics;
	}
	public int getCottageId() {
		return cottageId;
	}
	public void setCottageId(int cottageId) {
		this.cottageId = cottageId;
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
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getBehaviourRules() {
		return behaviourRules;
	}
	public void setBehaviourRules(String behaviourRules) {
		this.behaviourRules = behaviourRules;
	}
	public Set<String> getCottagePics() {
		return cottagePics;
	}
	public void setCottagePics(Set<String> cottagePics) {
		this.cottagePics = cottagePics;
	}


	public CottageOwner getOwner() {
		return owner;
	}


	public void setOwner(CottageOwner owner) {
		this.owner = owner;
	}


	public List<AvailabilityPeriodCottages> getAvailablePeriods() {
		return availablePeriods;
	}


	public void setAvailablePeriods(List<AvailabilityPeriodCottages> availablePeriods) {
		this.availablePeriods = availablePeriods;
	}

	public int getGuestsNum() {
		return guestsNum;
	}


	public void setGuestsNum(int guestsNum) {
		this.guestsNum = guestsNum;
	}
	
	

	public boolean isAvailableAndFree(LocalDateTime from, LocalDateTime to) {
		boolean available =false;
		for(AvailabilityPeriodCottages period : availablePeriods) {
			if(period.getBeggining().isBefore(from.toLocalDate()) && period.getEnding().isAfter(to.toLocalDate())) {
				available=true;			
			}
		}
		if(!available) return false;
		for(ReservationCottage reservation : reservations) {
			
			if(!(      (from.toLocalDate().isBefore(reservation.getBeginning().toLocalDate()) && to.toLocalDate().isBefore(reservation.getBeginning().toLocalDate()))    ||     (from.toLocalDate().isAfter(reservation.getEnding().toLocalDate()) && to.toLocalDate().isAfter(reservation.getEnding().toLocalDate()))  ) && !reservation.isCanceled() && reservation.getFisherman()!=null)
					{
					
					return false;
					}
				}
			return true;
			}


	public void addReservation(ReservationCottage newReservation) {
		reservations.add(newReservation);
		
	}


	public boolean removeAction(LocalDateTime from, LocalDateTime to) {
		boolean res = reservations.removeIf(r -> (!(      (from.toLocalDate().isBefore(r.getBeginning().toLocalDate()) && to.toLocalDate().isBefore(r.getBeginning().toLocalDate()))    ||     (from.toLocalDate().isAfter(r.getEnding().toLocalDate()) && to.toLocalDate().isAfter(r.getEnding().toLocalDate()))  ) && r.isActionRes() && r.getFisherman()==null ));
		return res;
	}


	public List<ReservationCottage> getActiveActions() {
		List<ReservationCottage> res = new ArrayList<>();
		for(ReservationCottage reservation : reservations) {
				if(reservation.isActionRes() && reservation.getActionStartTime().isBefore(LocalDateTime.now()) && reservation.getActionEndTime().isAfter(LocalDateTime.now()) && reservation.getFisherman()==null)
					res.add(reservation);
		}
		return res;
	}


	public void changeActionRes(int reservationId, Fisherman fisherman) {
		for(ReservationCottage reservation : reservations) {
			if(reservation.getReservationId()== reservationId )
				reservation.setFisherman(fisherman);
	}		
		
	}


	public void addNewSubscription(SubscriptionCottage newOne) {
		subscriptions.add(newOne);
		
	}


	public void removeSubscription(String email) {
		subscriptions.removeIf(s-> s.getFisherman().getEmail().equals(email));
		
	}


	public void cancelReservation(int reservationId) {
		for(ReservationCottage s: reservations) {
			if(s.getReservationId()==reservationId)
				s.setCanceled(true);
		}
		
	}


	public void cancelActionRes(int reservationId) {
		for(ReservationCottage s: reservations) {
			if(s.getReservationId()==reservationId)
				s.setFisherman(null);
		}
		
	}


	public boolean atLeastOnceReserved(String email) {
		for(ReservationCottage r : reservations) {
			if(r.getFisherman().getEmail().equals(email) && !r.isCanceled() && r.getEnding().toLocalDate().isBefore(LocalDate.now())) {
				return true;
			}
		}
		return false;
	}


	public void addComplaint(ComplaintCottage complaint) {
		complaints.add(complaint);
		
	}


	public boolean alreadyComplained(String email) {
		for(ComplaintCottage c: complaints) {
			if(c.getFisherman().getEmail().equals(email))
				return true;
		}
		return false;
	}
			
		

}


	

