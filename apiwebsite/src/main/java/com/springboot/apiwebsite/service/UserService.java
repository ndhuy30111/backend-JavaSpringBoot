package com.springboot.apiwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.UserEntity;
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
	public UserEntity saveUser(UserEntity userEntity) {
		BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
		String passwordnew =  bcry.encode(userEntity.getPassword());
		userEntity.setPassword(passwordnew);
		return entityRepository.save(userEntity);
	}

}
