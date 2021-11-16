package com.fishNdream.backend.entity.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.SignUpRequest;

@Entity
public class Instructor extends UserInfo {

	@JsonView(Views.UnauthoInstuctors.class)
	private String shortBio;
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Adventure.class)
	@JsonView(Views.UnauthoInstuctors.class)
	private List<Adventure> adventures; 
	
	
	public Instructor(SignUpRequest request) {
		super(request.getEmail(), request.getName(),request.getSurname(), request.getAdress(), request.getCity(), request.getState(),
				request.getPhoneNum());
	}
	public Instructor() {}

	public List<Adventure> getAdventures() {
		return adventures;
	}

	public void setAdventures(List<Adventure> adventures) {
		this.adventures = adventures;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
	
}
