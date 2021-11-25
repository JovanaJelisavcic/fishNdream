package com.fishNdream.backend.entity.intercations;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationBoat extends ReservationInfo {
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReservationBoat.class);
	
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	@JsonView(Views.UnauthoBoats.class)
	private Boat boat;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	

	@ManyToMany
	@JsonView(Views.AdditionalServices.class)
	private List<AdditionalServicesBoat> additionalServices;
	
	public List<AdditionalServicesBoat> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServicesBoat> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public ReservationBoat(Boat boat, Fisherman fisherman, List<AdditionalServicesBoat> additionalServices) {
		super();
		this.boat = boat;
		this.fisherman = fisherman;
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
	

	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

	public boolean isCaptainBusy(LocalDateTime beginning, LocalDateTime ending) {
		
		for(AdditionalServicesBoat service : additionalServices) {
			if(service.getName().toUpperCase().contains("Capetain".toUpperCase()))
				return true;
		}
		return false;
	}
	
	

}
