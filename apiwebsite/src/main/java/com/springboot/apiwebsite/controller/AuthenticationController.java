package com.springboot.apiwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.model.AuthenticationRequest;
import com.springboot.apiwebsite.model.AuthenticationResponse;
import com.springboot.apiwebsite.service.MyUserDetailsService;
import com.springboot.apiwebsite.service.UserService;
import com.springboot.apiwebsite.util.JwtUtil;


@RestController
@CrossOrigin
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired 
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private UserService userService;
	@PostMapping(value = "/api/Authentication")
	public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e){
			throw new Exception("Tài khoản mật khẩu có thể sai");
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	@PostMapping("/api/dangky")
	public ResponseEntity<?>createUser(@Valid @RequestBody UserEntity user) throws Exception{
		try {
			UserEntity userEntityNew = userService.save(user);
			return new ResponseEntity<>(userEntityNew,HttpStatus.CREATED);	
		}catch(Exception e) {
			throw new Exception("Trung ten");
		}
	}
	@GetMapping("/api/account")
	public ResponseEntity<?>getUser(){
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
	}

	}

