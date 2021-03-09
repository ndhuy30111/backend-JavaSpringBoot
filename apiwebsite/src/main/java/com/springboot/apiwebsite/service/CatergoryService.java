package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.CatergoryEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.repository.CatergoryReponsitory;
import com.springboot.apiwebsite.service.impl.CatergoryServiceImpl;
import com.springboot.apiwebsite.util.SlugUtil;
@Service
public class CatergoryService implements CatergoryServiceImpl {
  
	@Autowired
	ProductService productService;
	@Autowired
	CatergoryReponsitory catergoryReponsitory;
	@Override
	public List<CatergoryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatergoryEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatergoryEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return catergoryReponsitory.findById(id).get();
	}

	@Override
	public CatergoryEntity save(CatergoryEntity t) {
		// TODO Auto-generated method stub
		t.setStatus(true);
		t.setUrl(SlugUtil.makeSlug(t.getName()));
		
		return catergoryReponsitory.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	

}
