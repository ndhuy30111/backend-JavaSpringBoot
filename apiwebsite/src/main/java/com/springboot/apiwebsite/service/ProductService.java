package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.repository.ProductRepository;
import com.springboot.apiwebsite.service.impl.ProductServiceImpl;
import com.springboot.apiwebsite.util.SlugUtil;
@Service
public class ProductService implements ProductServiceImpl{
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<ProductEntity> getAll() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> getAll(int page,int size) {
		Pageable paging = PageRequest.of(page, size);
		return productRepository.findAll(paging).getContent();
		
	}

	@Override
	public ProductEntity save(ProductEntity productEntity) {
		productEntity.setUrl(SlugUtil.makeSlug(productEntity.getName()));
		return productRepository.save(productEntity);
	}
	
}
