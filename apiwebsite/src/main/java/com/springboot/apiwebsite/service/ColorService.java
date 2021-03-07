package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.repository.ColorReponsitory;
import com.springboot.apiwebsite.service.impl.ColorServiceImpl;
@Service
public class ColorService implements ColorServiceImpl{

	@Autowired
	ColorReponsitory colorReponsitory;

	@Override
	public List<ColorEntity> findAll() {
		// TODO Auto-generated method stub
		return colorReponsitory.findAll();
	}

	@Override
	public List<ColorEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorEntity save(ColorEntity t) {
		// TODO Auto-generated method stub
		return colorReponsitory.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		colorReponsitory.deleteById(id);
	}

	@Override
	public ColorEntity findColor(String productUrl, String colorName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
