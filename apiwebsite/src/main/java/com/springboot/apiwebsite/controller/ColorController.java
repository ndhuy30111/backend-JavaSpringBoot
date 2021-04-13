package com.springboot.apiwebsite.controller;

import java.util.List;

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
import com.springboot.apiwebsite.entity.SizeEntity;
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
		if(colorFind==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		colorFind.setName(colorEntity.getName());
		colorFind.setCode(colorEntity.getCode());
		
		colorService.save(colorFind);
		return new ResponseEntity<>(colorFind,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteColor(@PathVariable Long id){
		if(colorService.findByIdOne(id)==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		colorService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/{id}/size")
	public ResponseEntity<?> getSize(@PathVariable Long id){
		List<SizeEntity> listSize = colorService.findByIdOne(id).getSize();
		if(listSize.size()==0) {
			return new ResponseEntity<>(listSize,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listSize,HttpStatus.OK);
	}

}
