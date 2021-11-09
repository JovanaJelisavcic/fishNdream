package com.fishNdream.backend.entity.users;

import javax.persistence.Entity;

@Entity
public class Fisherman extends UserInfo{

	public Fisherman(UserInfo user) {
		super(user);
	}
	public Fisherman() {}
}