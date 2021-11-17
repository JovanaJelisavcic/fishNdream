package com.fishNdream.backend.entity.helper;

import java.time.LocalDateTime;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class SerachDTO {
	
	@NotNull(message="Dates are mandatory")
 	@Future(message="Date has to be in the future")
	 	private LocalDateTime dateTime;
	@NotNull(message="Dates are mandatory")
 	@Future(message="Date has to be in the future")
	    private LocalDateTime endTime;
		private String location;
		private int guestsNum;
	    public SerachDTO() {}
		public SerachDTO(LocalDateTime dateTime, LocalDateTime endTime) {
			super();
			this.dateTime = dateTime;
			this.endTime = endTime;
		}
		
		@AssertTrue
	  public boolean isValidRange() {
			    return dateTime.isBefore(endTime);
			  }
		
		public LocalDateTime getDateTime() {
			return dateTime;
		}
		public void setDateTime(LocalDateTime dateTime) {
			this.dateTime = dateTime;
		}
		public LocalDateTime getEndTime() {
			return endTime;
		}
		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public int getGuestsNum() {
			return guestsNum;
		}
		public void setGuestsNum(int guestsNum) {
			this.guestsNum = guestsNum;
		}

}
