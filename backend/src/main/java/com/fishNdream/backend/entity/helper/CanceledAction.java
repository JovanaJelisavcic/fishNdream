package com.fishNdream.backend.entity.helper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class CanceledAction {
	@Id
	@Column(nullable = false, unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int canceledId;
	@Enumerated(EnumType.STRING)
	private ActionType actionType;
	private int actionId;
	@ManyToOne
	@JoinColumn(name = "email")
	private Fisherman fisherman;

	public CanceledAction() {
	}

	public CanceledAction(ActionType actionType, int actionId, Fisherman fisherman) {
		super();
		this.actionType = actionType;
		this.actionId = actionId;
		this.fisherman = fisherman;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

}
