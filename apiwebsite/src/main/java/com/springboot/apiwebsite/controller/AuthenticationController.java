package com.springboot.apiwebsite.controller;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.entity.VerificationUserEntity;
import com.springboot.apiwebsite.exception.BadRequestEx;
import com.springboot.apiwebsite.model.AuthenticationRequest;
import com.springboot.apiwebsite.model.AuthenticationResponse;
import com.springboot.apiwebsite.repository.VerificationEmailReponsitory;
import com.springboot.apiwebsite.service.MyUserDetailsService;
import com.springboot.apiwebsite.service.SendMailService;
import com.springboot.apiwebsite.service.UserService;
import com.springboot.apiwebsite.service.VerificationEmailService;
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
	private VerificationEmailService verificationEmailService;
	@Autowired
	private VerificationEmailReponsitory verificationEmailReponsitory;
	@Autowired
	private SendMailService sendMailService;
	
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
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	@GetMapping("/api/profile")
	public ResponseEntity<?>profileUser(){
	 try {
		 String principal = SecurityContextHolder.getContext().getAuthentication().getName();
		 UserEntity userEntity =  userService.getFindUserName(principal);
		 
		 return new ResponseEntity<>(userEntity
				 ,HttpStatus.OK);	
	 }catch(Exception ex) {
		 throw new BadRequestEx("Không tìm thấy tài khoản");
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
            +"http://103.146.23.233/api/verification?token="+verificationUserEntity.getConfirmationToken());
            sendMailService.sendEmail(mailMessage);          
			return new ResponseEntity<>(userEntityNew,HttpStatus.CREATED);	
	}
	@GetMapping("/api/verification")
			public ResponseEntity<?>verification(@RequestParam(value = "token") String token)
			{	
		 		VerificationUserEntity verificationUserEntity = verificationEmailService.getVerificationToken(token);
		 		if(verificationUserEntity!=null) {

			 		UserEntity userEntity = verificationUserEntity.getUser();
			 		
					return new ResponseEntity<>(userService.isEnabled(userEntity),HttpStatus.OK);
		 		}
		 		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	
	@GetMapping("/api/account")
	public ResponseEntity<?>getUser(){
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
	}

}

