package com.springboot.apiwebsite.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {
	@PostMapping(value = "api/upload")
	public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file){
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
