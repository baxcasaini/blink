package com.blink.blinkapi.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
	@JsonProperty("username")
	private String email;
	@JsonProperty("password")
	private String password;

	public Account() {
	}

	public Account(String email, String password) {
		this.email = email;
		this.password = password;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}