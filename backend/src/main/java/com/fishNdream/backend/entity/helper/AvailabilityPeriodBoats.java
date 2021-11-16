package com.fishNdream.backend.entity.helper;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.basic.Boat;
@Entity
public class AvailabilityPeriodBoats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int periodId;
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	private Boat boat;
	private LocalDate beggining;
	private LocalDate ending;
	public AvailabilityPeriodBoats() {}

	public AvailabilityPeriodBoats(LocalDate beggining, LocalDate ending) {
		super();
		this.beggining = beggining;
		this.ending = ending;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
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
