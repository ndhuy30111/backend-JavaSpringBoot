package com.springboot.apiwebsite.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.slugify.Slugify;
import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.entity.ColorEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.exception.BadRequestEx;
import com.springboot.apiwebsite.exception.ProductEx;
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
	public ProductEntity save(@Valid ProductEntity productEntity)throws BadRequestEx {
		if(findOneByName(productEntity.getName())!=null)
		{
			throw new BadRequestEx("Tên sản phẩm đã tồn tại");
		}
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
	public ProductEntity findtByUrlOne(String url) {
	
		
		return productRepository.findOneByUrl(url);
	}

	@Override
	public ProductEntity findByIdOne(Long id) {

		// TODO Auto-generated method stub

		return productRepository.findById(id).get();
	}
	public List<ProductEntity> getProduct(String name)
	{
		
		return productRepository.findByNameLike(name);
	}

	@Override
	public ProductEntity findOneByName(String name) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = productRepository.findOneByName(name);
		productEntity.setCategory(productRepository.findOneByName(name).getCategory());
		return productEntity;
	}

	@Override
	public List<CategoryEntity> getCategoryProduct(String url) {		 
		return findtByUrlOne(url).getCategory();
	}

	


	
}
