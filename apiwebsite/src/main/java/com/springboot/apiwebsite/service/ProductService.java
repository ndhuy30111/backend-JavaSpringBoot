package com.springboot.apiwebsite.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.entity.ProductEntity;
import com.springboot.apiwebsite.exception.BadRequestEx;
import com.springboot.apiwebsite.repository.ProductRepository;
import com.springboot.apiwebsite.service.impl.ProductServiceImpl;
@Service
public class ProductService implements ProductServiceImpl{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductEntity> findPage(int page,int size) 
	{   Sort sortOrder = Sort.by("name");
		Pageable paging = PageRequest.of(page, size,sortOrder);
		return productRepository.findAll(paging).getContent();
	}

	@Override
	@Transactional
	public ProductEntity save(ProductEntity productEntity)throws BadRequestEx {
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

	public void remove(Long id) throws BadRequestEx {
		try {
		productRepository.deleteForeignById(id);
		productRepository.deleteById(id);
		}catch (BadRequestEx e) {
			throw new BadRequestEx("Không thể xóa sản phẩm này!");
		}
		
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
		return productEntity;
	}

	@Override
	public List<CategoryEntity> getCategoryProduct(String url) {		 
		return findtByUrlOne(url).getCategory();
	}

	


	
}
