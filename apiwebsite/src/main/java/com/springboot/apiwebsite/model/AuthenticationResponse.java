package com.springboot.apiwebsite.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class AuthenticationResponse {
	@NotBlank(message = "Jwt của bạn trống")
	private String jwt;
	private Date date;
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthenticationResponse(String jwt,Date date) {
		super();
		this.jwt = jwt;
		this.date= date;
	}
	
}
