package com.fishNdream.backend.entity.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.helper.AvailabilityPeriodBoats;
import com.fishNdream.backend.entity.helper.NavigationTool;
import com.fishNdream.backend.entity.intercations.ComplaintBoat;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.intercations.SubscriptionBoat;
import com.fishNdream.backend.entity.users.BoatOwner;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class Boat {
	
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Boat.class);
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.UnauthoBoats.class)
	private int boatId;
	@JsonView(Views.UnauthoBoats.class)
	private String name;
	@JsonView(Views.UnauthoBoats.class)
	private float price;
	@JsonView(Views.BoatProfile.class)
	private String boatType;
	@JsonView(Views.BoatProfile.class)
	private float length;
	@JsonView(Views.BoatProfile.class)
	private int engineNum;
	@JsonView(Views.BoatProfile.class)
	private float enginePower;
	@JsonView(Views.BoatProfile.class)
	private int maxSpeed;
	@JsonView(Views.UnauthoBoats.class)
	private String description;
	@JsonView(Views.UnauthoBoats.class)
	private String address;
	@JsonView(Views.UnauthoBoats.class)
	private float rating;
	@JsonView(Views.UnauthoBoats.class)
	private int capacity;
	@JsonView(Views.BoatProfile.class)
	private String behaviourRules;
	@JsonView(Views.BoatProfile.class)
	@Enumerated(EnumType.STRING)
	private NavigationTool navigationTool;
	@JsonView(Views.BoatProfile.class)
	private String equipment;
	@ElementCollection
	@CollectionTable(name = "boat_pics", joinColumns = @JoinColumn(name = "boat_id"))
	@JsonView(Views.UnauthoBoats.class)
	private Set<String> boatPics = new HashSet<>();
	@JsonView(Views.BoatProfile.class)
	private boolean cancelPolicy; // 0-besplatno 
	@ManyToOne
	@JsonView(Views.BoatProfile.class)
	private BoatOwner owner;
	@OneToMany(
	        mappedBy = "boat",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<AvailabilityPeriodBoats> availablePeriods;	
	@OneToMany(
	        mappedBy = "boat",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	
	@JsonView(Views.AdditionalServices.class)
	private List<AdditionalServicesBoat> additionalServices;
	
	@Transient
	@JsonView(Views.UnauthoBoats.class)
	private List<AvailabilityPeriodBoats> unavailablePeriods = new ArrayList<AvailabilityPeriodBoats>();	


	@OneToMany(
	        mappedBy = "boat",
	        cascade = CascadeType.PERSIST,
	        		fetch=FetchType.EAGER,
	        orphanRemoval = true
	    )
	
	private List<ReservationBoat> reservations;
	@OneToMany(
	        mappedBy = "boat",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<SubscriptionBoat> subscrpitions;
	
	@OneToMany(
	        mappedBy = "boat",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ComplaintBoat> complaints;
	
	
	@PostLoad
	private void fillUnavalability() {
		this.unavailablePeriods.addAll(unFromAvailable());
		this.unavailablePeriods.addAll(unFromReservations());
		Collections.sort(this.unavailablePeriods,new Comparator<AvailabilityPeriodBoats>() {
		    @Override
		    public int compare(AvailabilityPeriodBoats a1, AvailabilityPeriodBoats a2) {
		        return (a1.getBeggining().isBefore(a2.getBeggining())) ? -1 : ( a1.getBeggining().equals(a2.getBeggining())? (a1.getEnding().isBefore(a2.getEnding())? -1: 1) : 1  );
		    }
		});
	}
	
	
	private Collection<? extends AvailabilityPeriodBoats> unFromReservations() {
		ArrayList<AvailabilityPeriodBoats> result = new ArrayList<>();
		for(ReservationBoat r : reservations) {
			if(!r.isCanceled() && r.getFisherman()!=null) {
				AvailabilityPeriodBoats a= new AvailabilityPeriodBoats();
				a.setBeggining(r.getBeginning());
				a.setEnding(r.getEnding());
				result.add(a);
			}
				
		}
		return result;
	}


	private Collection<? extends AvailabilityPeriodBoats> unFromAvailable() {
		ArrayList<AvailabilityPeriodBoats> result = new ArrayList<>();
		if(this.availablePeriods==null) return result;
		
		Collections.sort(this.availablePeriods,new Comparator<AvailabilityPeriodBoats>() {
		    @Override
		    public int compare(AvailabilityPeriodBoats a1, AvailabilityPeriodBoats a2) {
		        return (a1.getBeggining().isBefore(a2.getBeggining())) ? -1 : ( a1.getBeggining().equals(a2.getBeggining())? (a1.getEnding().isBefore(a2.getEnding())? -1: 1) : 1  );
		    }
		});
	
		
		
		if(this.availablePeriods.get(0).getBeggining().isAfter(LocalDateTime.now())) {
			AvailabilityPeriodBoats a= new AvailabilityPeriodBoats();
			a.setBeggining(LocalDateTime.now());
			a.setEnding(this.availablePeriods.get(0).getBeggining());
			result.add(a);
		}
		
		if(this.availablePeriods.size()==1) {

			AvailabilityPeriodBoats a= new AvailabilityPeriodBoats();
			a.setBeggining(this.availablePeriods.get(0).getEnding());
			a.setEnding(LocalDateTime.MAX);
			result.add(a);
		}else {
			for(int i=0;i<this.availablePeriods.size()-1; i++) {
				AvailabilityPeriodBoats a= new AvailabilityPeriodBoats();
				a.setBeggining(this.availablePeriods.get(i).getEnding());
				a.setEnding(this.availablePeriods.get(i+1).getBeggining());
				result.add(a);
			}
			AvailabilityPeriodBoats a= new AvailabilityPeriodBoats();
			a.setBeggining(this.availablePeriods.get(this.availablePeriods.size()-1).getEnding());
			a.setEnding(LocalDateTime.MAX);
			result.add(a);
			
		}
		
		
		
		return result;
	}


	public List<ComplaintBoat> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<ComplaintBoat> complaints) {
		this.complaints = complaints;
	}

	public List<AdditionalServicesBoat> getAdditionalServices() {
		return additionalServices;
	}

	public List<SubscriptionBoat> getSubscrpitions() {
		return subscrpitions;
	}

	public void setSubscrpitions(List<SubscriptionBoat> subscrpitions) {
		this.subscrpitions = subscrpitions;
	}

	public void setAdditionalServices(List<AdditionalServicesBoat> additionalServices) {
		this.additionalServices = additionalServices;
	}
	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public List<AvailabilityPeriodBoats> getAvailablePeriods() {
		return availablePeriods;
	}

	public void setAvailablePeriods(List<AvailabilityPeriodBoats> availablePeriods) {
		this.availablePeriods = availablePeriods;
	}

	public List<ReservationBoat> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationBoat> reservations) {
		this.reservations = reservations;
	}

	public Boat() {}
	
	public Boat(int boatId, String name, String type, float length, int engineNum, float enginePower, int maxSpeed,
			String description, String address, int capacity, String behaviourRules, Set<String> boatPics,
			boolean cancelPolicy) {
		super();
		this.boatId = boatId;
		this.name = name;
		this.boatType = type;
		this.length = length;
		this.engineNum = engineNum;
		this.enginePower = enginePower;
		this.maxSpeed = maxSpeed;
		this.description = description;
		this.address = address;
		this.capacity = capacity;
		this.behaviourRules = behaviourRules;
		this.boatPics = boatPics;
		this.cancelPolicy = cancelPolicy;
	}
	public int getBoatId() {
		return boatId;
	}
	public void setBoatId(int boatId) {
		this.boatId = boatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return boatType;
	}
	public void setType(String type) {
		this.boatType = type;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public NavigationTool getNavigationTool() {
		return navigationTool;
	}


	public void setNavigationTool(NavigationTool navigationTool) {
		this.navigationTool = navigationTool;
	}
	public int getEngineNum() {
		return engineNum;
	}
	public void setEngineNum(int engineNum) {
		this.engineNum = engineNum;
	}
	public float getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(float enginePower) {
		this.enginePower = enginePower;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getBehaviourRules() {
		return behaviourRules;
	}
	public void setBehaviourRules(String behaviourRules) {
		this.behaviourRules = behaviourRules;
	}
	public Set<String> getBoatPics() {
		return boatPics;
	}
	public void setBoatPics(Set<String> boatPics) {
		this.boatPics = boatPics;
	}

	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public boolean isCancelPolicy() {
		return cancelPolicy;
	}
	public void setCancelPolicy(boolean cancelPolicy) {
		this.cancelPolicy = cancelPolicy;
	}

	public BoatOwner getOwner() {
		return owner;
	}

	public void setOwner(BoatOwner owner) {
		this.owner = owner;
	}

	

	public boolean isAvailableAndFree(LocalDateTime from, LocalDateTime to) {
		boolean available =false;
		
		for(AvailabilityPeriodBoats period : availablePeriods) {
			if(period.getBeggining().isBefore(from) && period.getEnding().isAfter(to))
				available=true;			
		}
		if(!available) return false;
		else {
			
			for(ReservationBoat reservation : reservations) {
				if(!(      (from.isBefore(reservation.getBeginning()) && to.isBefore(reservation.getBeginning()))    ||     (from.isAfter(reservation.getEnding()) && to.isAfter(reservation.getEnding()))  ) && !reservation.isCanceled() && reservation.getFisherman()!=null)
					return false;
			}
			return true;
		}
	}

	public void addReservation(ReservationBoat newReservation) {
		reservations.add(newReservation);
		
	}

	public List<AdditionalServicesBoat> getAdditionalServicesForTime(LocalDateTime beginning, LocalDateTime ending) {
	
		List<AdditionalServicesBoat> res = new ArrayList<>();
		for(AdditionalServicesBoat service : additionalServices) {
		
			if(service.getName().toUpperCase().contains("Capetain".toUpperCase())) {
				
				if(owner.checkIfAvailableForService(beginning,ending)) res.add(service);
			}else res.add(service);
		}
		return res;
	}

	public List<ReservationBoat> getActiveActions() {
		List<ReservationBoat> res = new ArrayList<>();
		for(ReservationBoat reservation : reservations) {
				if(reservation.isActionRes() && reservation.getActionStartTime().isBefore(LocalDateTime.now()) && reservation.getActionEndTime().isAfter(LocalDateTime.now()) && reservation.getFisherman()==null)
				{
					
					res.add(reservation);}
		}
		return res;
	}

	public void changeActionRes(int reservationId, Fisherman fisherman) {
		for(ReservationBoat reservation : reservations) {
				if(reservation.getReservationId()== reservationId )
					reservation.setFisherman(fisherman);
		}		
	}


	public Boat removeAction(LocalDateTime from, LocalDateTime to, boolean containsCaptain) {
		reservations.removeIf(r -> ( !(      (from.isBefore(r.getBeginning()) && to.isBefore(r.getBeginning()))    ||     (from.isAfter(r.getEnding()) && to.isAfter(r.getEnding()))  ) && r.isActionRes() && r.getFisherman()==null ));
		if(containsCaptain)		return owner.removeAction(from,to);
		return null;
	}

	public void removeReservation(ReservationBoat r) {
		reservations.remove(r);
		
	}

	public void addNewSubscription(SubscriptionBoat newOne) {
		subscrpitions.add(newOne);
		
	}

	public void removeSubscription(String email) {
	subscrpitions.removeIf(s-> s.getFisherman().getEmail().equals(email));
		
	}

	public void cancelReservation(int reservationId) {
		for(ReservationBoat s: reservations) {
			if(s.getReservationId()==reservationId)
				s.setCanceled(true);
		}
		
	}

	public void cancelActionRes(int reservationId) {
		for(ReservationBoat s: reservations) {
			if(s.getReservationId()==reservationId)
				s.setFisherman(null);
		}
		
	}


	public boolean alreadyComplained(String email) {
		for(ComplaintBoat c: complaints) {
			if(c.getFisherman().getEmail().equals(email))
				return true;
		}
		return false;
	}

	public void addComplaint(ComplaintBoat complaint) {
		complaints.add(complaint);
		
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<AvailabilityPeriodBoats> getUnavailablePeriods() {
		return unavailablePeriods;
	}

	public void setUnavailablePeriods(List<AvailabilityPeriodBoats> unavailablePeriods) {
		this.unavailablePeriods = unavailablePeriods;
	}



	
	
	
}
