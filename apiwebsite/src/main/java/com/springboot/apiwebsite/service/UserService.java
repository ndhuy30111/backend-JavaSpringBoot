package com.springboot.apiwebsite.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.apiwebsite.controller.AuthenticationController;
import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.exception.BadRequestEx;
import com.springboot.apiwebsite.repository.EntityRepository;
import com.springboot.apiwebsite.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{
	@Autowired
	EntityRepository entityRepository;
	@Override
	public UserEntity getFindUserName(String userName) {
		if(userName != null) {
			return entityRepository.findByUserName(userName);
		}
		return null;
	}
	@Override
	@Transactional
	public UserEntity save(@Valid UserEntity userEntity) throws BadRequestEx{
		try {
			if(getFindUserByEmail(userEntity.getEmail())!=null) {
				throw new BadRequestEx("Email Da Ton tai");
			}
			if(getFindUserName(userEntity.getUserName())!=null) {
				throw new BadRequestEx("user name da ton tai ");
			}
			 String userName = userEntity.getUserName();
			 if(userName.matches(".*\\s+.*"))
			 {
				 throw new BadRequestEx("tai khoan khong hop le");
			 }

			BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
			String passwordnew =  bcry.encode(userEntity.getPassword());
			userEntity.setStatus(true);
			userEntity.setEnabled(false);
			userEntity.setPassword(passwordnew);
			return entityRepository.save(userEntity);	
		}catch(Exception ex) {
			throw new BadRequestEx(ex.getMessage());
		}	
	}
	@Override
	public List<UserEntity> findAll() {
		return entityRepository.findAll();
	}
	@Override
	public List<UserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return entityRepository.findAll();
	}
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public UserEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserEntity getFindUserByEmail(String email) {
		// TODO Auto-generated method stub
		return entityRepository.findOneByEmail(email);
	}
	@Override
	public UserEntity isEnabled(UserEntity userEntity) {
		userEntity.setEnabled(true);
		return entityRepository.save(userEntity);
	}
	
	
	

}
