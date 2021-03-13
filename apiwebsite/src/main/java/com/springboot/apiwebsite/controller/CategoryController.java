package com.springboot.apiwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CategoryEntity categoryEntity){
		try {
		 CategoryEntity category	=  categoryService.save(categoryEntity);
		 return new ResponseEntity<>(category,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/product")
	public ResponseEntity<?> category_product(@RequestBody CategoryEntity categoryEntity){
		try {
			 CategoryEntity category = categoryService.category_prodcut(categoryEntity);
			 return new ResponseEntity<>(category,HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
			}
	}
}
