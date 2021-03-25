package com.springboot.apiwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.model.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userService.getFindUserName(username);

		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserDetails(user);
	}

}
