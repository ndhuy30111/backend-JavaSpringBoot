package com.springboot.apiwebsite.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apiwebsite.entity.CatergoryEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.service.CatergoryService;
import com.springboot.apiwebsite.service.ProductService;

@RestController
public class CatergoryController {
	
	@Autowired 
	CatergoryService catergoryService;
	@Autowired
	ProductService productService; 
	@PostMapping("api/catergory")
	public ResponseEntity<?> save(@Valid @RequestBody CatergoryEntity catergoryEntity)
	{
		try {

			CatergoryEntity  catergoryEntityNew=  catergoryService.save(catergoryEntity);
			return new ResponseEntity<>(catergoryEntityNew,HttpStatus.OK);	
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/api/catergory-product")
	public ResponseEntity<?>catergory_product(@RequestBody CatergoryEntity catergoryEntity){
		try {
			List<ProductEntity> listProduct = catergoryEntity.getProduct();
			CatergoryEntity cateEntity = catergoryService.findByIdOne(catergoryEntity.getId());
			List<ProductEntity> listCatergory = cateEntity.getProduct();
			for(ProductEntity productItem:listProduct) {
				ProductEntity find = productService.findByIdOne(productItem.getId());
				if(listCatergory.indexOf(find)<0) {
					listCatergory.add(productItem);
				}
				
			} 
					cateEntity.setProduct(listCatergory);
			CatergoryEntity catergoryEntityNew = catergoryService.save(cateEntity);
			return new ResponseEntity<>(cateEntity,HttpStatus.OK);	
		}catch(Exception ex) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}
}
