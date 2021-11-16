package com.fishNdream.backend.entity.helper;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.basic.Adventure;

@Entity
public class AvailabilityPeriodAdventures {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int periodId;
	@ManyToOne
    @JoinColumn(name="adventure_id", nullable=false)
	private Adventure adventure;
	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	private LocalDate beggining;
	private LocalDate ending;
	public AvailabilityPeriodAdventures() {}

	public AvailabilityPeriodAdventures(LocalDate beggining, LocalDate ending) {
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
}

