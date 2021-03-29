package com.springboot.apiwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.entity.VerificationUserEntity;
import com.springboot.apiwebsite.exception.AccountEx;
import com.springboot.apiwebsite.model.AuthenticationRequest;
import com.springboot.apiwebsite.model.AuthenticationResponse;
import com.springboot.apiwebsite.repository.VerificationEmailReponsitory;
import com.springboot.apiwebsite.service.MyUserDetailsService;
import com.springboot.apiwebsite.service.SendMailService;
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
	@Autowired
	private VerificationEmailReponsitory verificationEmailReponsitory;
	@Autowired
	private SendMailService sendMailService;
	@PostMapping(value = "/api/Authentication")
	public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e){
			throw new AccountEx("Sai tài khoản hoặc mật khẩu");
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	@PostMapping("/api/profile")
	public ResponseEntity<?>profileUser(@Valid @RequestParam(value = "jwt") String jwt){
	 try {
		 String userName = jwtTokenUtil.extractUsername(jwt);
		 UserEntity userEntity = userService.getFindUserName(userName);
		 return new ResponseEntity<>(userEntity,HttpStatus.OK);	
	 }catch(Exception ex) {
		 throw new AccountEx("Không tìm thấy tài khoản");
	 }	
		
		
	}
	@PostMapping("/api/dangky")
	public ResponseEntity<?>createUser( @RequestBody UserEntity user) throws Exception{
		   UserEntity userEntityNew = userService.save(user);
			VerificationUserEntity verificationUserEntity = new VerificationUserEntity(userEntityNew);
			verificationEmailReponsitory.save(verificationUserEntity);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("ttemp5478@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8080/api/verification?token="+verificationUserEntity.getConfirmationToken());
            sendMailService.sendEmail(mailMessage);
            
			return new ResponseEntity<>(userEntityNew,HttpStatus.CREATED);	
	}
	@GetMapping("/api/verification")
			public ResponseEntity<?> verification(@RequestParam(value = "token") String token)
			{
		
				return new ResponseEntity<>(HttpStatus.OK);
			}
	
	@GetMapping("/api/account")
	public ResponseEntity<?>getUser(){
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
	}

	}

