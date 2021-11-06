package com.fishNdream.backend.entity.users;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class UserInfo {
		
		@Id
		@Column(nullable=false, unique =true,
		        updatable=false)
		private String email;
		@NotBlank(message = "Name is mandatory")
		
		private String name;
		@NotBlank(message = "Surname is mandatory")
		
		private String surname;
		@NotBlank(message = "Adress is mandatory")
		
		private String address;
		@NotBlank(message = "City is mandatory")
		
		private String city;
		@NotBlank(message = "State is mandatory")
	
		private String state;
		@NotBlank(message = "Phone number is mandatory")
		
		private String phoneNum;

		public UserInfo() {}
		
		public UserInfo(String email, String name, String surname, String adress, String city, String state,
				String phoneNum) {
			super();
			this.email = email;
			this.name = name;
			this.surname = surname;
			this.address = adress;
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

		public String getAdress() {
			return address;
		}

		public void setAdress(String adress) {
			this.address = adress;
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
