package com.fishNdream.backend.entity.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.helper.SignUpRequest;

@Entity
public class BoatOwner extends UserInfo {
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Boat.class)
	private List<Boat> boats;


	public BoatOwner(SignUpRequest request) {
		super(request.getEmail(), request.getName(),request.getSurname(), request.getAdress(), request.getCity(), request.getState(),
				request.getPhoneNum());
	}
	
	public BoatOwner() {}

	public List<Boat> getBoats() {
		return boats;
	}

	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	} 
	
	

}
