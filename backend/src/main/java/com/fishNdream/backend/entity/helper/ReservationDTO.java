package com.fishNdream.backend.entity.helper;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class ReservationDTO {
	
	@NotNull(message="Dates are mandatory")
 	@Future(message="Date has to be in the future")
	private LocalDateTime beginning; 
	@NotNull(message="Dates are mandatory")
 	@Future(message="Date has to be in the future")
	private LocalDateTime ending;
	private int participantsNum;
	private int entityId;
	private List<Integer> servicesIds;
	
	public ReservationDTO() {}
	public ReservationDTO(LocalDateTime beginning, LocalDateTime ending, int participantsNum, int entityId,
			List<Integer> servicesIds) {
		super();
		this.beginning = beginning;
		this.ending = ending;
		this.participantsNum = participantsNum;
		this.entityId = entityId;
		this.servicesIds = servicesIds;
	}
	 @AssertTrue public boolean isValidRange() {
		    return beginning.isBefore(ending);
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
	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public List<Integer> getServicesIds() {
		return servicesIds;
	}
	public void setServicesIds(List<Integer> servicesIds) {
		this.servicesIds = servicesIds;
	}
	
	


}
