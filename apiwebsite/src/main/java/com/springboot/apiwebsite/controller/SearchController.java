package com.springboot.apiwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.service.CategoryService;
import com.springboot.apiwebsite.service.ProductService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

	@Autowired 
	ProductService productService;
	
	@Autowired
	CategoryService categoryService; 
	

	@GetMapping("product/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name)
	{
		return new ResponseEntity<>(productService.getProduct(name),HttpStatus.OK);
	}
	}
