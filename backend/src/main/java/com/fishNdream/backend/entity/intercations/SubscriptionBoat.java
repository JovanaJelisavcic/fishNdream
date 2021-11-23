package com.fishNdream.backend.entity.intercations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class SubscriptionBoat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.UnauthoBoats.class)
	private int subscriptionId;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	@JsonView(Views.UnauthoBoats.class)
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	private Boat boat;
	
	public SubscriptionBoat() {}
	
	
	
	public SubscriptionBoat(Fisherman fisherman, Boat boat) {
		super();
		this.fisherman = fisherman;
		this.boat = boat;
	}



	public Fisherman getFisherman() {
		return fisherman;
	}
	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}



	public Boat getBoat() {
		return boat;
	}



	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	
	

}

