package com.fishNdream.backend.entity.intercations;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemGain {
	@Id
	@Column(nullable=false, unique =true,
	        updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int gainId;
		private float percentage;
		private LocalDate beginning;
		private LocalDate ending;
		public SystemGain(float percentage, LocalDate beginning, LocalDate ending) {
			super();
			this.percentage = percentage;
			this.beginning = beginning;
			this.ending = ending;
		}
		public SystemGain() {}
		public float getPercentage() {
			return percentage;
		}
		public void setPercentage(float percentage) {
			this.percentage = percentage;
		}
		public LocalDate getBeginning() {
			return beginning;
		}
		public void setBeginning(LocalDate beginning) {
			this.beginning = beginning;
		}
		public LocalDate getEnding() {
			return ending;
		}
		public void setEnding(LocalDate ending) {
			this.ending = ending;
		}
		
		
}
