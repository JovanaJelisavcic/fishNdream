package com.fishNdream.backend.entity.helper;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fishNdream.backend.entity.users.UserInfo;
import com.fishNdream.backend.security.ERole;

@Entity
public class SignUpRequest extends UserInfo {
	@Enumerated(EnumType.STRING)
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
