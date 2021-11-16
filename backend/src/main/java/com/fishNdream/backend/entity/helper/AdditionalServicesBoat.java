package com.fishNdream.backend.entity.helper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.basic.Boat;

@Entity
public class AdditionalServicesBoat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId; 
	private String name;
	private float price;
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	private Boat boat;

	public AdditionalServicesBoat() {}

	public AdditionalServicesBoat(String name, float price, Boat boat) {
		super();
		this.boat = boat;
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

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	
}
