package com.springboot.apiwebsite.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.springboot.apiwebsite.entity.ProductEntity;

public interface ProductServiceImpl extends GeneralService<ProductEntity>{
	
	public List<ProductEntity> findPage(int page,int size);
	@Query(name="Select p from Product p where p.url =?1",nativeQuery =true )
	public ProductEntity findUrl(String url);
	
}
