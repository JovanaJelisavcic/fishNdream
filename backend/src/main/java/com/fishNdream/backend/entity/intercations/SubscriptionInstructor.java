package com.fishNdream.backend.entity.intercations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;

@Entity
public class SubscriptionInstructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.UnauthoInstuctors.class)
	private int subscriptionId;
	@ManyToOne
	 @JoinColumn(name="email")
	private Fisherman fisherman;
	@JsonView(Views.UnauthoInstuctors.class)
	@ManyToOne
    @JoinColumn(name="instr_id", referencedColumnName="email")
	private Instructor instructor;
	
	public SubscriptionInstructor() {}
	
	
	
	public SubscriptionInstructor(Fisherman fisherman, Instructor instructor) {
		super();
		this.fisherman = fisherman;
		this.instructor = instructor;
	}



	public Fisherman getFisherman() {
		return fisherman;
	}
	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}



	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}



	

}
