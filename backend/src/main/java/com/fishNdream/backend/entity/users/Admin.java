package com.fishNdream.backend.entity.users;

import javax.persistence.Entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@SQLDelete(sql = "UPDATE admin SET deleted = true WHERE email=?")
@Where(clause = "deleted=false")
public class Admin extends UserInfo{

	public Admin() {}

}
