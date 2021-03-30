package com.springboot.apiwebsite.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.springboot.apiwebsite.util.JwtUtil;

public class AuthenticationResponse {
	@NotBlank(message = "Jwt của bạn trống")
	private String jwt;
	private Date date;
	public void setDate(Date date) {
		this.date = date;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Date getDate() {
		
		return date;
	}



	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
		date = new JwtUtil().extractExpiration(jwt);
	}
	
}
