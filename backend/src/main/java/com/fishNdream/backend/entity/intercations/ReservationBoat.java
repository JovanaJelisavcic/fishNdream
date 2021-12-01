package com.fishNdream.backend.entity.intercations;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationBoat extends ReservationInfo {
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReservationBoat.class);
	@Transient
	@JsonView(Views.ReservationView.class)
	private long duration;
	
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	@JsonView(Views.UnauthoBoats.class)
	private Boat boat;
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
	private List<AdditionalServicesBoat> additionalServices;
	
	@PostLoad
    public void doStuff(){
		duration = ChronoUnit.MINUTES.between(super.getBeginning(), super.getEnding());
		discount= 100-calculateDiscountPricePrc();
    }
	
	private float calculateDiscountPricePrc() {
		int addition = (duration%60==0)?0:1;
		float original=boat.getPrice()*(Math.round(duration/60)+ addition);
		for(AdditionalServicesBoat s : additionalServices) {
			original+=s.getPrice();
		}
		this.originalPrice=original;
		return super.getPrice()*100/original;
		
	}
	
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
