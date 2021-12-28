package com.fishNdream.backend.entity.helper;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
@Entity
public class AvailabilityPeriodBoats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int periodId;
	@ManyToOne
    @JoinColumn(name="boat_id", nullable=false)
	private Boat boat;
	@JsonView(Views.UnauthoBoats.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime beggining;
	@JsonView(Views.UnauthoBoats.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime ending;
	public AvailabilityPeriodBoats() {}

	public AvailabilityPeriodBoats(LocalDateTime beggining, LocalDateTime ending) {
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

	public LocalDateTime getBeggining() {
		return beggining;
	}

	public void setBeggining(LocalDateTime beggining) {
		this.beggining = beggining;
	}

	public LocalDateTime getEnding() {
		return ending;
	}

	public void setEnding(LocalDateTime ending) {
		this.ending = ending;
	}


}
