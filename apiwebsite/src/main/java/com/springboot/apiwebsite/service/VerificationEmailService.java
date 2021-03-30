package com.springboot.apiwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.VerificationUserEntity;
import com.springboot.apiwebsite.repository.VerificationEmailReponsitory;
import com.springboot.apiwebsite.service.impl.VerificationEmailServiceImpl;

@Service
public class VerificationEmailService implements VerificationEmailServiceImpl{

	@Autowired
	VerificationEmailReponsitory verificationEmailReponsitory;
	@Override
	public VerificationUserEntity getVerificationToken(String token) {		
		
		try {
			VerificationUserEntity a = verificationEmailReponsitory.findOneByConfirmationToken(token);	
			return a;
		}catch(Exception ex)
		{
		return null;	
		}
		
	}
	

}
