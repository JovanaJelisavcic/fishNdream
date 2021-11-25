package com.fishNdream.backend.entity.intercations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ComplaintBoat {
	@Id
	@Column(nullable=false, unique =true,
	        updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Complaint.class)
	private int complaintId;	
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	@JsonView(Views.UnauthoBoats.class)
	private Boat boat;
	@ManyToOne
	 @JoinColumn(name="email")
	@JsonView(Views.UserInfo.class)
	private Fisherman fisherman;
	@JsonView(Views.Complaint.class)
	private String complaintText;
	private String response;
	
	public ComplaintBoat() {}
	

	public Boat getBoat() {
		return boat;
	}


	public void setBoat(Boat boat) {
		this.boat = boat;
	}


	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

	public String getComplaintText() {
		return complaintText;
	}

	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ComplaintBoat(int complaintId, Boat boat, Fisherman fisherman, String complaintText, String response) {
		super();
		this.complaintId = complaintId;
		this.boat = boat;
		this.fisherman = fisherman;
		this.complaintText = complaintText;
		this.response = response;
	}

	
	

}