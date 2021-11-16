package com.fishNdream.backend.entity.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.helper.SignUpRequest;


@Entity
public class CottageOwner extends UserInfo {
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Cottage.class)
	private List<Cottage> cottages;

	public CottageOwner(SignUpRequest request) {
		
		super(request.getEmail(), request.getName(),request.getSurname(), request.getAdress(), request.getCity(), request.getState(),
				request.getPhoneNum());
	}
	
	public CottageOwner() {}

	public List<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(List<Cottage> cottages) {
		this.cottages = cottages;
	} 
	
	
	
	
}
