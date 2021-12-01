package com.fishNdream.backend.entity.intercations;

import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesAdventure;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationAdventure extends ReservationInfo{
	
	@Transient
	@JsonView(Views.ReservationView.class)
	private long duration;

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
	
	@PostLoad
    public void doStuff(){
		duration = ChronoUnit.MINUTES.between(super.getBeginning(), super.getEnding());
    }
	
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

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	
	
}
