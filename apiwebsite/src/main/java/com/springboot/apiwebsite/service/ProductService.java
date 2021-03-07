package com.springboot.apiwebsite.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.repository.ProductRepository;
import com.springboot.apiwebsite.service.impl.ProductServiceImpl;
import com.springboot.apiwebsite.util.SlugUtil;
@Service
public class ProductService implements ProductServiceImpl{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> findPage(int page,int size) {
		Pageable paging = PageRequest.of(page, size);
		return productRepository.findAll(paging).getContent();
	}

	@Transactional
	@Override
	public ProductEntity save(@Valid ProductEntity productEntity) throws SQLException {
		try {
			productEntity.setUrl(SlugUtil.makeSlug(productEntity.getName()));
			ProductEntity productNew=  productRepository.save(productEntity);	
			return productNew;
		}catch(Exception e) {
			throw new SQLException("Loi ko them dc");
		}
		
	}

	@Override
	public List<ProductEntity> findAll() {	
		 return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> findById(Long id) {
		return null;
	}

	@Override
	public void remove(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public ProductEntity findUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
