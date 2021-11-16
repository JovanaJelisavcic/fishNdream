package com.fishNdream.backend.entity.users;

import javax.persistence.Entity;
import javax.validation.Valid;

import com.fishNdream.backend.entity.helper.ChangeInfoDTO;

@Entity
public class Fisherman extends UserInfo{
	
	public Fisherman(UserInfo user) {
		super(user);
	}
	public Fisherman() {}
	public void changeUserInfo(@Valid ChangeInfoDTO user) {
		if(user.getAddress()!=null)
			if(!user.getAddress().equals(super.getAdress()))
				super.setAdress(user.getAddress());
		if(user.getCity()!=null)
			if(!user.getCity().equals(super.getCity()))
				super.setCity(user.getCity());
		if(user.getName()!=null)
			if(!user.getName().equals(super.getName()))
				super.setName(user.getName());
		if(user.getPhoneNum()!=null)
			if(!user.getPhoneNum().equals(super.getPhoneNum()))
				super.setPhoneNum(user.getPhoneNum());
		if(user.getState()!=null)
			if(!user.getState().equals(super.getState()))
				super.setState(user.getState());
		if(user.getSurname()!=null)
			if(!user.getSurname().equals(super.getSurname()))
				super.setSurname(user.getSurname());
		
		
		
	}
	
}