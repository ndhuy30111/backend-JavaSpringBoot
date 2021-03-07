package com.springboot.apiwebsite.controller;

import java.sql.SQLException;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.service.ProductService;


@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size){
		return new ResponseEntity<>(productService.findPage(page, size),HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductEntity productEntity) throws Exception{
		try {
			ProductEntity productEntityNew = productService.save(productEntity);
			return new ResponseEntity<>(productEntityNew,HttpStatus.CREATED);	
		}catch(ValidationException ex) {
			throw new ValidationException("Loi");
		}
	}
	@PostMapping
	@Transactional(rollbackFor = {SQLException.class})
	public ResponseEntity<?> save(@RequestParam(value = "product") String product,@RequestParam(name = "file",required = false) MultipartFile file)throws Exception{
		try {
			ProductEntity  productEntity =  new ObjectMapper().readValue(product,ProductEntity.class);
			ProductEntity productNew =	(ProductEntity) saveProduct(productEntity).getBody();
			return new ResponseEntity<>(productNew,HttpStatus.CREATED);	
		}catch(ValidationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping(value = "/{url}")
	public ResponseEntity<?> findUrl(@PathVariable("url") String url)
	{
		return new ResponseEntity<>(url,HttpStatus.OK);
	}
	
	}

