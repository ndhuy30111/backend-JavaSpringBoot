package com.springboot.apiwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.service.ProductService;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size){
		return new ResponseEntity<>(productService.getAll(page, size),HttpStatus.OK);
	}
	@PostMapping
	
	public ResponseEntity<?> save(@RequestParam("product") String product,@RequestParam(name = "file",required = false) MultipartFile file)throws Exception{
		try {
			ProductEntity productEntity = new ObjectMapper().readValue(product,ProductEntity.class);
			return new ResponseEntity<>(productEntity,HttpStatus.CREATED);	
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
