package com.springboot.apiwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.springboot.apiwebsite.service.ImageService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ImageUploadController {
	@Autowired
	ImageService imageService;
	 @PostMapping("/upload")
	  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    imageService.save(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED); 
	    }
	  }

	 @GetMapping("/files/{filename:.+}")
	
	  public ResponseEntity<?> getFile(@PathVariable String filename) {
	    Resource file = imageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
}
