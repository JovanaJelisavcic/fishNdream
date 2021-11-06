package com.fishNdream.backend.entity.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fishNdream.backend.entity.basic.Adventure;

@Entity
public class Instructor extends UserInfo {

	private String shortBio;
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Adventure.class)
	private List<Adventure> adventures; 
	
	
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
