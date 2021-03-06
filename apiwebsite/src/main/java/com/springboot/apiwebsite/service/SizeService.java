package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.SizeEntity;
import com.springboot.apiwebsite.repository.SizeRepository;
import com.springboot.apiwebsite.service.impl.SizeServiceImpl;
@Service
public class SizeService implements SizeServiceImpl {

	@Autowired 
	private SizeRepository sizeReponsitory;
	@Override
	public List<SizeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
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
	public SizeEntity findSize(String productUrl, String colorName, String sizeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SizeEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return sizeReponsitory.findById(id).get();
	}

}
