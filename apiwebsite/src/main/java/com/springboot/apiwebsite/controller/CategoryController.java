package com.springboot.apiwebsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("/{url}")
	public ResponseEntity<?> findOneByUrl(@PathVariable String url)
	{
		return new ResponseEntity<>(categoryService.findByUrlOne(url),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody CategoryEntity categoryEntity){
		try {
		 CategoryEntity category	=  categoryService.save(categoryEntity);
		 return new ResponseEntity<>(category,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> category_product(@Valid @RequestBody CategoryEntity categoryEntity){
		try {
			 CategoryEntity category = categoryService.category_prodcut(categoryEntity);
			 return new ResponseEntity<>(category,HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
			}
	}
}
