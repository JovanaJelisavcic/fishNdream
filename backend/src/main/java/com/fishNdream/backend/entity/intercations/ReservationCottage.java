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
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesCottage;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationCottage extends ReservationInfo {
	
	@Transient
	@JsonView(Views.ReservationView.class)
	private long duration;
	@ManyToOne
    @JoinColumn(name="cottage_id", nullable=false)
	@JsonView(Views.UnauthoCottages.class)
	private Cottage cottage;
	@ManyToMany
	@JsonView(Views.AdditionalServices.class)
	private List<AdditionalServicesCottage> additionalServices;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	
	
	@PostLoad
    public void doStuff(){
		duration = ChronoUnit.DAYS.between(super.getBeginning(), super.getEnding());
    }
	
	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

	public List<AdditionalServicesCottage> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServicesCottage> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public ReservationCottage() {}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	public ReservationCottage(Cottage cottage) {
		super();
		this.cottage = cottage;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	

}
