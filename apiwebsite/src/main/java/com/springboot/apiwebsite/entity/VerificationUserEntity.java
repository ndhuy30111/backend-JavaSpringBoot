package com.springboot.apiwebsite.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="verification_user")
@Getter
@Setter
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class VerificationUserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;
    @Column(name="confirmation_token")
    private String confirmationToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToOne(fetch = FetchType.EAGER,targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public VerificationUserEntity(UserEntity userEntity) {
        this.user = userEntity;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
    

	public VerificationUserEntity() {
		super();
	}


	public VerificationUserEntity(long tokenid, String confirmationToken, Date createdDate, UserEntity user) {
		super();
		this.tokenid = tokenid;
		this.confirmationToken = confirmationToken;
		this.createdDate = createdDate;
		this.user = user;
	}


	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	public VerificationUserEntity() {
		super();
	}


	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	
	

}
