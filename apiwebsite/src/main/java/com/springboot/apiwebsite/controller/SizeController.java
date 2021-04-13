package com.springboot.apiwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.SizeEntity;
import com.springboot.apiwebsite.service.SizeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/size")
public class SizeController {
	@Autowired
	private SizeService sizeService;
	@GetMapping("/{id}")
	public ResponseEntity<?> getId(@PathVariable Long id) {
		SizeEntity sizeFind = sizeService.findByIdOne(id);
		if(sizeFind==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(sizeFind,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> putColor(@PathVariable Long id, @RequestBody SizeEntity colorEntity){
		SizeEntity colorFind = sizeService.findByIdOne(id);
		if(colorFind==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		colorFind.setName(colorEntity.getName());
		colorFind.setAmount(colorEntity.getAmount());
		
		sizeService.save(colorFind);
		return new ResponseEntity<>(colorFind,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteColor(@PathVariable Long id){
		if(sizeService.findByIdOne(id)==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		sizeService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
