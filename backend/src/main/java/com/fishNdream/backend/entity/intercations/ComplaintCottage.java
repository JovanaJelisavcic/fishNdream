package com.fishNdream.backend.entity.intercations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class ComplaintCottage {
	@Id
	@Column(nullable=false, unique =true,
	        updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Complaint.class)
	private int complaintId;	
	@ManyToOne
    @JoinColumn(name="cottage_id", nullable=false)
	@JsonView(Views.UnauthoCottages.class)
	private Cottage cottage;
	@ManyToOne
	 @JoinColumn(name="email")
	@JsonView(Views.UserInfo.class)
	private Fisherman fisherman;
	@JsonView(Views.Complaint.class)
	private String complaintText;
	private String response;
	
	public ComplaintCottage() {}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
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

	public ComplaintCottage(int complaintId, Cottage cottage, Fisherman fisherman, String complaintText,
			String response) {
		super();
		this.complaintId = complaintId;
		this.cottage = cottage;
		this.fisherman = fisherman;
		this.complaintText = complaintText;
		this.response = response;
	}
	
	

}
