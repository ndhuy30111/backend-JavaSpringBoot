package com.springboot.apiwebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserEntity extends BasicEntitySuper{
	
	@Column(name = "username",length = 50)
	@NotNull(message = "Bạn không được để null Username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	

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
	
}
