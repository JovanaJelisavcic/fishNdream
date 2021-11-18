package com.fishNdream.backend.entity.intercations;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationBoat extends ReservationInfo {
	
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	private Boat boat;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	
	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

	@ManyToMany
	private List<AdditionalServicesBoat> additionalServices;
	
	public List<AdditionalServicesBoat> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServicesBoat> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public ReservationBoat() {}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public ReservationBoat(Boat boat) {
		super();
		this.boat = boat;
	}

	public boolean isCaptainBusy(LocalDateTime beginning, LocalDateTime ending) {
		for(AdditionalServicesBoat service : additionalServices) {
			if(service.getName().toUpperCase().contains("Capetain".toUpperCase()))
				return true;
		}
		return false;
	}
	
	

}
