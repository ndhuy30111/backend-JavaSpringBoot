package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.apiwebsite.entity.VerificationUserEntity;

public interface VerificationEmailReponsitory extends JpaRepository<VerificationUserEntity, Long> {
  
	VerificationUserEntity findOneByConfirmationToken(String confirmationToken);
}
