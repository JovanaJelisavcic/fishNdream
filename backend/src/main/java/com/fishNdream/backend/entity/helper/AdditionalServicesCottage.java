package com.fishNdream.backend.entity.helper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;

@Entity
public class AdditionalServicesCottage  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.AdditionalServices.class)
	private int serviceId; 
	@JsonView(Views.AdditionalServices.class)
	private String name;
	@JsonView(Views.AdditionalServices.class)
	private float price;
	@ManyToOne
    @JoinColumn(name="cottage_id", nullable=false)
	private Cottage cottage;
	public AdditionalServicesCottage(String name, float price, Cottage cottage) {
		super();
		this.cottage = cottage;
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

	public Cottage getCottage() {
		return cottage;
	}
	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	} 
	public AdditionalServicesCottage() {}

}
