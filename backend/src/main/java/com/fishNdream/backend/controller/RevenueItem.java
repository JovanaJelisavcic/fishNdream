package com.fishNdream.backend.controller;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fishNdream.backend.entity.helper.ActionType;

@Entity
public class RevenueItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int revenueId;
	private int reservationId;
	 @Enumerated(EnumType.STRING)
	private ActionType resType;
	
	private float fishermanPrice;
	private float revenue;
	private float percentageActive;
	
	public RevenueItem() {}

	public RevenueItem(int reservationId, ActionType resType, float fishermanPrice, float revenue,
			float percentageActive) {
		super();
		this.reservationId = reservationId;
		this.resType = resType;
		this.fishermanPrice = fishermanPrice;
		this.revenue = revenue;
		this.percentageActive = percentageActive;
	}

	public int getRevenueId() {
		return revenueId;
	}

	public void setRevenueId(int revenueId) {
		this.revenueId = revenueId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public ActionType getResType() {
		return resType;
	}

	public void setResType(ActionType resType) {
		this.resType = resType;
	}

	public float getFishermanPrice() {
		return fishermanPrice;
	}

	public void setFishermanPrice(float fishermanPrice) {
		this.fishermanPrice = fishermanPrice;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

	public float getPercentageActive() {
		return percentageActive;
	}

	public void setPercentageActive(float percentageActive) {
		this.percentageActive = percentageActive;
	}
	
	

}
