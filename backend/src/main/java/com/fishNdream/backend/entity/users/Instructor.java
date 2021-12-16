package com.fishNdream.backend.entity.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.intercations.ComplaintInstructor;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;
import com.fishNdream.backend.entity.intercations.SubscriptionInstructor;

@Entity
public class Instructor extends UserInfo {

	@JsonView(Views.UnauthoInstuctors.class)
	private String shortBio;
	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Adventure.class)
	@JsonView(Views.UnauthoInstuctors.class)
	private List<Adventure> adventures;
	@JsonView(Views.UnauthoInstuctors.class)
	private float rating;
	@OneToMany(
	        mappedBy = "instructor",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<SubscriptionInstructor> subscriptions; 
	@OneToMany(
	        mappedBy = "instructor",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<ComplaintInstructor> complaints;
	
	
	
	public Instructor(SignUpRequest request) {
		super(request.getEmail(), request.getName(),request.getSurname(), request.getAdress(), request.getCity(), request.getState(),
				request.getPhoneNum());
	}
	public Instructor() {}

	public List<Adventure> getAdventures() {
		return adventures;
	}

	public List<ComplaintInstructor> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<ComplaintInstructor> complaints) {
		this.complaints = complaints;
	}
	public List<SubscriptionInstructor> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<SubscriptionInstructor> subscriptions) {
		this.subscriptions = subscriptions;
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
	public void addNewSubscription(SubscriptionInstructor newOne) {
		subscriptions.add(newOne);
	}
	public void removeSubscription(String email) {
		subscriptions.removeIf(s-> s.getFisherman().getEmail().equals(email));
		
	}
	public boolean atLeastOnceReserved(String email) {
		for(Adventure a : adventures) {
			for(ReservationAdventure r : a.getReservations()) {
				if(!r.isCanceled() && r.getFisherman().getEmail().equals(email) && r.getEnding().isBefore(LocalDateTime.now()) )
						return true;
			}
		}
		return false;
	}
	public boolean alreadyComplained(String email) {
		for(ComplaintInstructor c : complaints) {
			if(c.getFisherman().getEmail().equals(email))
				return true;
		}
		return false;
	}
	public void addComplaint(ComplaintInstructor complaint) {
		complaints.add(complaint);
		
	}
	public List<Integer> getAdventureIds() {
		List<Integer> res = new ArrayList<Integer>();
		if(adventures.isEmpty()) res.add(0);
		for(Adventure c: adventures) {
			res.add(c.getAdventureId());
		}
		return res;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
