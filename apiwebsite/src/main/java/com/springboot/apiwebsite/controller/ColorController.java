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
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.service.ColorService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/color")
public class ColorController {
	@Autowired
	private ColorService colorService;
	@GetMapping("/{id}")
	public ResponseEntity<?> getId(@PathVariable Long id) {
		
		return new ResponseEntity<>(colorService.findByIdOne(id),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> putColor(@PathVariable Long id, @RequestBody ColorEntity colorEntity){
		ColorEntity colorFind = colorService.findByIdOne(id);
		colorFind.setName(colorEntity.getName());
		colorFind.setCode(colorEntity.getCode());
		
		colorService.save(colorFind);
		return new ResponseEntity<>(colorFind,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteColor(@PathVariable Long id){
		colorService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/{id}/size")
	public ResponseEntity<?> getSize(@PathVariable Long id){
		return new ResponseEntity<>(colorService.findByIdOne(id).getSize(),HttpStatus.OK);
	}

}
