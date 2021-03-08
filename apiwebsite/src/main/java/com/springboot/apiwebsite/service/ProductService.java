package com.springboot.apiwebsite.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.ColorEntity;
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

	@Override
	@Transactional
	public ProductEntity save(@Valid ProductEntity productEntity) {
		productEntity.setUrl(SlugUtil.makeSlug(productEntity.getName()));

		return productRepository.save(productEntity);
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

	@Override
	public ProductEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}




	
}
