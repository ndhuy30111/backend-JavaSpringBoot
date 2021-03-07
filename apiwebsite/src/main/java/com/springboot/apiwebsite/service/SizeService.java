package com.springboot.apiwebsite.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.SizeEntity;
import com.springboot.apiwebsite.repository.SizeReponsitory;
import com.springboot.apiwebsite.service.impl.SizeServiceImpl;

@Service
public class SizeService implements SizeServiceImpl {
 
	@Autowired
	SizeReponsitory sizeReponsitory;
	@Override
	public List<SizeEntity> findAll() {
		// TODO Auto-generated method stub
		return sizeReponsitory.findAll();
	}

	@Override
	public List<SizeEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SizeEntity save(SizeEntity t) {
		// TODO Auto-generated method stub
		return sizeReponsitory.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		sizeReponsitory.deleteById(id);
		
	}

	@Override
	 @Transactional
	public SizeEntity findSize(String productUrl, String colorName, String sizeName) {
		// TODO Auto-generated method stub
		return sizeReponsitory.findBySize(sizeName,colorName,productUrl);
		
	}
	
	
	
}
