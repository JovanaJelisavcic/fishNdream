package com.fishNdream.backend.entity.helper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;

@Entity
public class AdditionalServicesAdventure{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.AdditionalServices.class)
	private int serviceId; 
	@JsonView(Views.AdditionalServices.class)
	private String name;
	@JsonView(Views.AdditionalServices.class)
	private float price;
	@ManyToOne
    @JoinColumn(name="adventure_id", nullable=false)
	private Adventure adventure;
	
	public AdditionalServicesAdventure() {}

	public AdditionalServicesAdventure(String name, float price, Adventure adventure) {
		super();
		this.adventure = adventure;
	}

	

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}
	

}
