package com.fishNdream.backend.entity.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.users.Instructor;

@Entity
public class Adventure {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adventureId;
	private String name;
	private String address;
	private String description;
	private int maxParticipants;
	private String behaviourRules;
	private boolean cancelPolicy; // 0-free
	@ManyToOne
	private Instructor instructor;
	
	public Adventure() {}
	
	public Adventure(int adventureId, String name, String address, String description, int maxParticipants,
			String behaviourRules, boolean cancelPolicy) {
		super();
		this.adventureId = adventureId;
		this.name = name;
		this.address = address;
		this.description = description;
		this.maxParticipants = maxParticipants;
		this.behaviourRules = behaviourRules;
		this.cancelPolicy = cancelPolicy;
	}
	public int getAdventureId() {
		return adventureId;
	}
	public void setAdventureId(int adventureId) {
		this.adventureId = adventureId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxParticipants() {
		return maxParticipants;
	}
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	public String getBehaviourRules() {
		return behaviourRules;
	}
	public void setBehaviourRules(String behaviourRules) {
		this.behaviourRules = behaviourRules;
	}
	public boolean isCancelPolicy() {
		return cancelPolicy;
	}
	public void setCancelPolicy(boolean cancelPolicy) {
		this.cancelPolicy = cancelPolicy;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
