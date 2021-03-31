package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BasicEntitySuper{
	
	@Column(name = "username",length = 50,unique = true)
	@NotNull(message = "Bạn không được để null Username")
	@Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",message = "User Name không hợp lệ")
	private String userName;
	
	@JsonBackReference
	@Column(name="password")
	@NotBlank(message = "Không được null password")
	private String password;
	
	@Column(name="email",unique = true)
	@NotNull(message = "Email Null ")
	@Pattern(regexp = "^(.+)@(.+)$",message = "Email không hợp lệ")
	private String email;
	
	@Column(name="isenabled",columnDefinition = "boolean default 0")
	private boolean isEnabled;
	
	@ManyToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<RoleEntity> role;
	
	@OneToMany(mappedBy = "user")
	private List<InvoiceEntity> invoice;
	
	@JsonIgnore
	@OneToOne(mappedBy = "user")
	VerificationUserEntity verificationUserEntity;
	
	
	
	public VerificationUserEntity getVerificationUserEntity() {
		return verificationUserEntity;
	}
	public void setVerificationUserEntity(VerificationUserEntity verificationUserEntity) {
		this.verificationUserEntity = verificationUserEntity;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
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
		BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
		 this.password = bcry.encode(password);
	}
	
	
}
