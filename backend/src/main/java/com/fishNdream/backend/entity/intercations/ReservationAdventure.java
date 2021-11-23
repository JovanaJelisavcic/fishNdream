package com.fishNdream.backend.entity.intercations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesAdventure;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationAdventure extends ReservationInfo{

	@ManyToOne
    @JoinColumn(name="adventure_id", nullable=false)
	@JsonView(Views.UnauthoInstuctors.class)
	private Adventure adventure;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	
	@ManyToMany
	@JsonView(Views.AdditionalServices.class)
	private List<AdditionalServicesAdventure> additionalServices;
	
	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	public List<AdditionalServicesAdventure> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServicesAdventure> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public ReservationAdventure() {}

	public ReservationAdventure(Adventure adnevture) {
		super();
		this.adventure = adnevture;
	}

	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

	
	
}
