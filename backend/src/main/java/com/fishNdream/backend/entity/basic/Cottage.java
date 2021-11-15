package com.fishNdream.backend.entity.basic;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.users.CottageOwner;

@Entity
public class Cottage {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.UnauthoCottages.class)
	private int cottageId;
	@JsonView(Views.UnauthoCottages.class)
	private String name;
	@JsonView(Views.UnauthoCottages.class)
	private String address;
	@JsonView(Views.UnauthoCottages.class)
	private String description;
	private int roomNum;
	private String behaviourRules;
	@ElementCollection
	@CollectionTable(name = "cottage_pics", joinColumns = @JoinColumn(name = "cottage_id"))
	private Set<String> cottagePics = new HashSet<>();
	@ManyToOne
	private CottageOwner owner;
	
	public Cottage() {}
	
	
	public Cottage(int cottageId, String name, String address, String description, int roomNum, String behaviourRules,
			Set<String> cottagePics) {
		super();
		this.cottageId = cottageId;
		this.name = name;
		this.address = address;
		this.description = description;
		this.roomNum = roomNum;
		this.behaviourRules = behaviourRules;
		this.cottagePics = cottagePics;
	}
	public int getCottageId() {
		return cottageId;
	}
	public void setCottageId(int cottageId) {
		this.cottageId = cottageId;
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
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getBehaviourRules() {
		return behaviourRules;
	}
	public void setBehaviourRules(String behaviourRules) {
		this.behaviourRules = behaviourRules;
	}
	public Set<String> getCottagePics() {
		return cottagePics;
	}
	public void setCottagePics(Set<String> cottagePics) {
		this.cottagePics = cottagePics;
	}


	public CottageOwner getOwner() {
		return owner;
	}


	public void setOwner(CottageOwner owner) {
		this.owner = owner;
	}
	
	
	
	
}
