package com.springboot.apiwebsite.service.impl;

import java.util.List;

import com.springboot.apiwebsite.entity.ProductEntity;

public interface ProductServiceImpl {
	public List<ProductEntity> getAll();
	public List<ProductEntity> getAll(int page,int size);
	ProductEntity save(ProductEntity productEntity);
}
