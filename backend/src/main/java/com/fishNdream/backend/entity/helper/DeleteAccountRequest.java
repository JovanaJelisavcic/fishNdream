package com.fishNdream.backend.entity.helper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Fisherman;

@Entity
public class DeleteAccountRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.DeleteRq.class)
	private int requestId;

	@OneToOne
    @JoinColumn(name="email", nullable=false)
	@JsonView(Views.UserInfo.class)
	private Fisherman fisherman;

	@JsonView(Views.DeleteRq.class)
	private String requestText;
	private String response;
	private boolean processed;
	private boolean permited;
	
	public DeleteAccountRequest() {}

	public Fisherman getFisherman() {
		return fisherman;
	}

	public void setFisherman(Fisherman fisherman) {
		this.fisherman = fisherman;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	public DeleteAccountRequest(int requestId, Fisherman fisherman, String response, boolean permited) {
		super();
		this.requestId = requestId;
		this.fisherman = fisherman;
		this.response = response;
	    this.processed = permited;
	}

	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public boolean isPermited() {
		return permited;
	}

	public void setPermited(boolean permited) {
		this.permited = permited;
	}
	

}
