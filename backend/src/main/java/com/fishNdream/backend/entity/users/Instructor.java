package com.fishNdream.backend.entity.users;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;

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
	public boolean isInstructorFree(LocalDateTime from, LocalDateTime to) {
		for(Adventure adventure : adventures) {
			for(ReservationAdventure reservation : adventure.getReservations()) {
				if(!(      (from.isBefore(reservation.getBeginning()) && to.isBefore(reservation.getBeginning()))    ||     (from.isAfter(reservation.getEnding()) && to.isAfter(reservation.getEnding()))  ) && !reservation.isCanceled() && reservation.getFisherman()!=null)
					return false;
			}
		}
		return true;
	}
	public Adventure removeAction(LocalDateTime from, LocalDateTime to) {
		for(Adventure a : adventures) {
			boolean removed = a.getReservations().removeIf(r -> ( !(      (from.isBefore(r.getBeginning()) && to.isBefore(r.getBeginning()))    ||     (from.isAfter(r.getEnding()) && to.isAfter(r.getEnding()))  ) && r.isActionRes() && r.getFisherman()==null ));
		    if(removed) return a;
		}
		return null;
	}
	
	
}
