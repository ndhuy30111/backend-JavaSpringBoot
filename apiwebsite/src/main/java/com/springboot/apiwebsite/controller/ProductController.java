package com.springboot.apiwebsite.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.entity.SizeEntity;
import com.springboot.apiwebsite.repository.ProductRepository;
import com.springboot.apiwebsite.service.ColorService;
import com.springboot.apiwebsite.service.ProductService;
import com.springboot.apiwebsite.service.SizeService;
import com.springboot.apiwebsite.service.impl.ColorServiceImpl;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		return new ResponseEntity<>(productService.findPage(page, size), HttpStatus.OK);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestParam(value = "product") String product,
			@RequestParam(name = "file", required = false) MultipartFile file)
			throws Exception, ValidationException, ValidationException {
		try {
			ProductEntity productEntity = new ObjectMapper().readValue(product, ProductEntity.class);
			
			ProductEntity productnew = productService.save(productEntity);
			for(ColorEntity itemColor : productnew.getColor()) {
				itemColor.setProduct(productnew);
				ColorEntity colorNew = colorService.save(itemColor);
				for(SizeEntity itemSize : colorNew.getSize()) {
					itemSize.setColor(colorNew);
					sizeService.save(itemSize);
				}
			}	
			return new ResponseEntity<>(productEntity,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}


}
