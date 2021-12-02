package com.fishNdream.backend.entity.intercations;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;

@MappedSuperclass
public class ReservationInfo {
	@Id
	@Column(nullable=false, unique =true,
	        updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ReservationView.class)
	private int reservationId;
	@JsonView(Views.ReservationView.class)
	private LocalDateTime beginning; 
	@JsonView(Views.ReservationView.class)
	private LocalDateTime ending;
	@JsonView(Views.ReservationView.class)
	private int participantsNum;
	@JsonView(Views.ReservationView.class)
	private float price;
	private boolean canceled;
	private boolean actionRes;
	@JsonView(Views.ActionInfo.class)
	private LocalDateTime actionStartTime;
	@JsonView(Views.ActionInfo.class)
	private LocalDateTime actionEndTime;
	private float percentageRevenue;



	public ReservationInfo() {}

	public ReservationInfo(int reservationId, LocalDateTime beginning, LocalDateTime ending, long duration,
			int participantsNum, float price) {
		super();
		this.reservationId = reservationId;
		this.beginning = beginning;
		this.ending = ending;
		this.participantsNum = participantsNum;
		this.price = price;
	}

	
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public LocalDateTime getBeginning() {
		return beginning;
	}

	public void setBeginning(LocalDateTime beginning) {
		this.beginning = beginning;
	}

	public LocalDateTime getEnding() {
		return ending;
	}

	public void setEnding(LocalDateTime ending) {
		this.ending = ending;
	}


	public int getParticipantsNum() {
		return participantsNum;
	}

	public void setParticipantsNum(int participantsNum) {
		this.participantsNum = participantsNum;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}


	public LocalDateTime getActionStartTime() {
		return actionStartTime;
	}

	public void setActionStartTime(LocalDateTime actionStartTime) {
		this.actionStartTime = actionStartTime;
	}



	public boolean isActionRes() {
		return actionRes;
	}

	public void setActionRes(boolean actionRes) {
		this.actionRes = actionRes;
	}

	public LocalDateTime getActionEndTime() {
		return actionEndTime;
	}

	public void setActionEndTime(LocalDateTime actionEndTime) {
		this.actionEndTime = actionEndTime;
	}

	public float getPercentageRevenue() {
		return percentageRevenue;
	}

	public void setPercentageRevenue(float f) {
		this.percentageRevenue = f;
	}
	
	
	

}
