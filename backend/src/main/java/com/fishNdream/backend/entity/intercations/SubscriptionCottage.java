package com.fishNdream.backend.entity.intercations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class SubscriptionCottage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.UnauthoCottages.class)
	private int subscriptionId;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	@JsonView(Views.UnauthoCottages.class)
	@ManyToOne
    @JoinColumn(name="cottage_id", nullable=false)
	private Cottage cottage;
	
	public SubscriptionCottage() {}
	
	
	
	public SubscriptionCottage(Fisherman fisherman, Cottage cottage) {
		super();
		this.fisherman = fisherman;
		this.cottage = cottage;
	}



	public Fisherman getFisherman() {
		return fisherman;
	}
	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}
	public Cottage getCottage() {
		return cottage;
	}
	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}
	

}
