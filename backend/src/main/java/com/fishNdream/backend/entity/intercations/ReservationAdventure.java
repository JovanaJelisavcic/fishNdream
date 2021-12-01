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
	@Transient
	@JsonView(Views.ActionInfo.class)
	private float discount;
	@Transient
	@JsonView(Views.ActionInfo.class)
	private float originalPrice;
	
	@ManyToMany
	@JsonView(Views.AdditionalServices.class)
	private List<AdditionalServicesAdventure> additionalServices;
	
	@PostLoad
    public void doStuff(){
		duration = ChronoUnit.MINUTES.between(super.getBeginning(), super.getEnding());
		discount = 100 - calculateDiscountPricePrc();
    }
	private float calculateDiscountPricePrc() {
		int addition = (duration%60==0)?0:1;
		float original=adventure.getPrice()*(Math.round(duration/60)+ addition);
		for(AdditionalServicesAdventure s : additionalServices) {
			original+=s.getPrice();
		}
		this.originalPrice=original;
		return super.getPrice()*100/original;
		
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

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}

	
	
}
