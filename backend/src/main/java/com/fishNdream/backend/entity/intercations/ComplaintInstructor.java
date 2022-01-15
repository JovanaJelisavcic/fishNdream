package com.fishNdream.backend.entity.intercations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;

@Entity
public class ComplaintInstructor {
	@Id
	@Column(nullable=false, unique =true,
	        updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Complaint.class)
	private int complaintId;	
	@ManyToOne
    @JoinColumn(name="instr_id", referencedColumnName="email", nullable=false)
	@JsonView(Views.UnauthoInstuctors.class)
	private Instructor instructor;
	@ManyToOne
	@JoinColumn(name="fisherman", referencedColumnName="email")
	@JsonView(Views.UserInfo.class)
	private Fisherman fisherman;
	@JsonView(Views.Complaint.class)
	private String complaintText;
	private String response;
	
	public ComplaintInstructor() {}

	

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



	public ComplaintInstructor(int complaintId, Instructor instructor, Fisherman fisherman, String complaintText,
			String response) {
		super();
		this.complaintId = complaintId;
		this.instructor = instructor;
		this.fisherman = fisherman;
		this.complaintText = complaintText;
		this.response = response;
	}



	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
	
	