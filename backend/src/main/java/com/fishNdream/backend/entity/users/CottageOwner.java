package com.fishNdream.backend.entity.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.SignUpRequest;


@Entity
public class CottageOwner extends UserInfo {
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Cottage.class)
	@JsonView(Views.CottageOwner.class)
	private List<Cottage> cottages;
	@JsonView(Views.CottageOwner.class)
	private float rating;
	

	public CottageOwner(SignUpRequest request) {
		
		super(request.getEmail(), request.getName(),request.getSurname(), request.getAdress(), request.getCity(), request.getState(),
				request.getPhoneNum());
	}
	
	public CottageOwner() {}

	public List<Cottage> getCottages() {
		return cottages;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setCottages(List<Cottage> cottages) {
		this.cottages = cottages;
	}

	public List<Integer> getCottagesIds() {
		
		List<Integer> res = new ArrayList<Integer>();
		if(cottages.isEmpty()) res.add(0);
		for(Cottage c: cottages) {
			res.add(c.getCottageId());
		}
		return res;
	}	

	
	
}
