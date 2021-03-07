package com.springboot.apiwebsite.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.valueextraction.ValueExtractorDeclarationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		return new ResponseEntity<>(productService.findPage(page, size), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestParam(value = "product") String product,
			@RequestParam(name = "file", required = false) MultipartFile file)
			throws Exception, ValidationException, ValidationException {
		try {
			ProductEntity productEntity = new ObjectMapper().readValue(product, ProductEntity.class);
			ProductEntity productSave = productService.save(productEntity);
			return new ResponseEntity<>(productSave, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
}
