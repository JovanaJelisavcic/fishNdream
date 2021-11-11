package com.fishNdream.backend.entity;


import javax.persistence.Entity;

import com.fishNdream.backend.entity.users.UserInfo;
import com.fishNdream.backend.security.ERole;

@Entity
public class SignUpRequest extends UserInfo {
	
	private ERole regType;
	
	private String explanation;
	
	public SignUpRequest() {}
	

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public ERole getRegType() {
		return regType;
	}


	public void setRegType(ERole regType) {
		this.regType = regType;
	}
	

}
