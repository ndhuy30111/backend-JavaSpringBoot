package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.repository.ColorRepository;
import com.springboot.apiwebsite.service.impl.ColorServiceImpl;
@Service
public class ColorService implements ColorServiceImpl {

	@Autowired 
	private ColorRepository colorRepository;
	@Override
	public List<ColorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColorEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorEntity save(ColorEntity t) {
		// TODO Auto-generated method stub
		return colorRepository.save(t);
	}

	@Override
	public void remove(Long id) {
		colorRepository.deleteById(id);
		
	}

	@Override
	public ColorEntity findColor(String productUrl, String colorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return colorRepository.getOne(id);
	}

}
