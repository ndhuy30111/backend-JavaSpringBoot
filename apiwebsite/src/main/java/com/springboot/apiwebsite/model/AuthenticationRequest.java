package com.springboot.apiwebsite.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthenticationRequest {
	@NotBlank(message = "Bạn không được bỏ tróng Username")
	private String userName;
	@NotBlank(message = "Bạn không được bỏ trống password")
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public AuthenticationRequest() {
		super();
	}
}
