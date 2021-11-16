package com.fishNdream.backend.entity.helper;


public class ChangeInfoDTO {
	
	private String email;
	
	private String name;
	
	private String surname;
	
	private String address;

	private String city;
	
	private String state;

	private String phoneNum;
	
	public ChangeInfoDTO() {}

	public ChangeInfoDTO(String email, String name, String surname, String address, String city, String state,
			String phoneNum) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	

}
