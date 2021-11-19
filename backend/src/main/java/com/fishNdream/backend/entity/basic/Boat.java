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
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.helper.AvailabilityPeriodBoats;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.users.BoatOwner;

@Entity
public class Boat {
	
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Boat.class);
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.UnauthoBoats.class)
	private int boatId;
	@JsonView(Views.UnauthoBoats.class)
	private String name;
	private String boatType;
	private float length;
	private int engineNum;
	private float enginePower;
	private int maxSpeed;
	@JsonView(Views.UnauthoBoats.class)
	private String description;
	@JsonView(Views.UnauthoBoats.class)
	private String address;
	private int capacity;
	private String behaviourRules;
	@ElementCollection
	@CollectionTable(name = "boat_pics", joinColumns = @JoinColumn(name = "boat_id"))
	private Set<String> boatPics = new HashSet<>();
	private boolean cancelPolicy; // 0-besplatno 
	@ManyToOne
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
	private List<AdditionalServicesBoat> additionalServices;
	
	

	@OneToMany(
	        mappedBy = "boat",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ReservationBoat> reservations;
	
	public List<AdditionalServicesBoat> getAdditionalServices() {
		return additionalServices;
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
			if(period.getBeggining().isBefore(from.toLocalDate()) && period.getEnding().isAfter(to.toLocalDate()))
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

	
	
	
}
