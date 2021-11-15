package com.fishNdream.backend.entity.users;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.util.FieldMatch;

@MappedSuperclass
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserInfo {
		
		@Id
		@Column(nullable=false, unique =true,
		        updatable=false)
		@JsonView(Views.UserInfo.class)
		private String email;
		@NotBlank(message = "Name is mandatory")
		@JsonView(Views.UserInfo.class)
		private String name;
		@NotBlank(message = "Surname is mandatory")
		@JsonView(Views.UserInfo.class)
		private String surname;
		@NotBlank(message = "Adress is mandatory")
		@JsonView(Views.UserInfo.class)
		private String address;
		@NotBlank(message = "City is mandatory")
		@JsonView(Views.UserInfo.class)
		private String city;
		@NotBlank(message = "State is mandatory")
		@JsonView(Views.UserInfo.class)
		private String state;
		@NotBlank(message = "Phone number is mandatory")
		@JsonView(Views.UserInfo.class)
		private String phoneNum;
		@Transient
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private String password;
		@Transient
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private String confirmPassword;
		
		
		
		
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

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
		
		public UserInfo(UserInfo user) {
			super();
			this.email = user.email;
			this.name = user.name;
			this.surname = user.surname;
			this.address = user.address;
			this.city = user.city;
			this.state = user.state;
			this.phoneNum = user.phoneNum;
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
