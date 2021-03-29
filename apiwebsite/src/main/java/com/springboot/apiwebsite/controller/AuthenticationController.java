package com.springboot.apiwebsite.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.exception.BadRequestEx;
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
	public ResponseEntity<?>createAuthenticationToken(@Valid @RequestBody AuthenticationRequest authenticationRequest)throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e){
			throw new BadRequestEx("Sai tài khoản hoặc mật khẩu");
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		Date date = jwtTokenUtil.extractExpiration(jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt,date));
	}
	@PostMapping("/api/profile")
	public ResponseEntity<?>profileUser(@Valid @RequestBody AuthenticationResponse auth){
	 try {
		 String userName = jwtTokenUtil.extractUsername(auth.getJwt());
		 UserEntity userEntity = userService.getFindUserName(userName);
		 return new ResponseEntity<>(userEntity,HttpStatus.OK);	
	 }catch(Exception ex) {
		 throw new BadRequestEx("Không tìm thấy tài khoản");
	 }	
		
		
	}
	@PostMapping("/api/dangky")
	public ResponseEntity<?>createUser( @RequestBody UserEntity user) throws Exception{
			UserEntity userEntityNew = userService.save(user);
			return new ResponseEntity<>(userEntityNew,HttpStatus.CREATED);	
	
	}
	
	@GetMapping("/api/account")
	public ResponseEntity<?>getUser(){
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
	}

	}

