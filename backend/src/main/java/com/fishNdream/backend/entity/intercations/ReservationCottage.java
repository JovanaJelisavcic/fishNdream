package com.fishNdream.backend.entity.intercations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.helper.AdditionalServicesCottage;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ReservationCottage extends ReservationInfo {
	
	@ManyToOne
    @JoinColumn(name="cottage_id", nullable=false)
	private Cottage cottage;
	@ManyToMany
	private List<AdditionalServicesCottage> additionalServices;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	
	
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
	
	

}
