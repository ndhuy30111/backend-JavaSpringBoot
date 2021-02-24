package com.springboot.apiwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getFindUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserDetails(user);
	}

}
