package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user")
public class UserEntity extends BasicEntitySuper{
	
	@Column(name = "username",length = 50)
	@NotNull(message = "Bạn không được để null Username")
	private String userName;
	@JsonBackReference
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy = "user")
	private List<InvoiceEntity> invoice;

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
