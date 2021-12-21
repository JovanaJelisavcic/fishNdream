package com.fishNdream.backend.entity.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SerachDTO {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="Dates are mandatory")
	 	private LocalDateTime dateTime;
 	@Future(message="Date has to be in the future")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
 	@NotNull(message="Dates are mandatory")
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
			    return dateTime.isBefore(endTime) && !dateTime.toLocalDate().isBefore(LocalDate.now());
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
