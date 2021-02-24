package com.springboot.apiwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.User;
import com.springboot.apiwebsite.repository.EntityRepository;
import com.springboot.apiwebsite.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{
	@Autowired
	EntityRepository entityRepository;
	@Override
	public User getFindUserName(String userName) {
		if(userName != null) {
			return entityRepository.findByUserName(userName);
		}
		return null;
	}

}
