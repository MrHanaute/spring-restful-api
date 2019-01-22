package com.api.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserRequestModel {
	@NotNull(message="nome não pode ser nulo")
	private String name;
	
	@NotNull(message="age não pode ser nulo")
	private String age;
		
	@NotNull(message="Email não pode ser nulo")
	@Email
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
