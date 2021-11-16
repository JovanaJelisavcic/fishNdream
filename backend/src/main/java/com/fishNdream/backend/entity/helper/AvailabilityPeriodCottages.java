package com.fishNdream.backend.entity.helper;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.basic.Cottage;
@Entity
public class AvailabilityPeriodCottages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int periodId;
	@ManyToOne
    @JoinColumn(name="cottage_id", nullable=false)
	private Cottage cottage;
	private LocalDate beggining;
	private LocalDate ending;
	public AvailabilityPeriodCottages() {}

	public AvailabilityPeriodCottages(LocalDate beggining, LocalDate ending) {
		super();
		this.beggining = beggining;
		this.ending = ending;
	}

	public LocalDate getBeggining() {
		return beggining;
	}

	public void setBeggining(LocalDate beggining) {
		this.beggining = beggining;
	}

	public LocalDate getEnding() {
		return ending;
	}

	public void setEnding(LocalDate ending) {
		this.ending = ending;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}
	
	

}
