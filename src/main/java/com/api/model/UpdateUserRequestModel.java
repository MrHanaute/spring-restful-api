package com.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UpdateUserRequestModel {
	@NotNull(message="nome não pode ser nulo")
	private String name;
		
	@NotNull(message="Email não pode ser nulo")
	@Email
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
