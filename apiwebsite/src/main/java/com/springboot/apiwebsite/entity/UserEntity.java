package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserEntity extends BasicEntitySuper{
	
	@Column(name = "username",length = 50,unique = true)
	@NotNull(message = "Bạn không được để null Username")
	private String userName;
	@JsonBackReference
	@Column(name="password")
	private String password;
	@Column(name="email",unique = true)
	private String email;
	@Column(name="isEnabled")
	@NotNull(message = "Không null")
	private boolean isEnabled;
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleEntity> getRole() {
		return role;
	}
	public void setRole(List<RoleEntity> role) {
		this.role = role;
	}
	
	@ManyToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<RoleEntity> role;
	@OneToMany(mappedBy = "user")
	private List<InvoiceEntity> invoice;


	public List<InvoiceEntity> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<InvoiceEntity> invoice) {
		this.invoice = invoice;
	}
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
