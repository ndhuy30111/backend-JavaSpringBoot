package com.springboot.apiwebsite.service.impl;

import java.util.List;

import com.springboot.apiwebsite.entity.ProductEntity;

public interface ProductServiceImpl extends GeneralServiceImpl<ProductEntity>{
	public List<ProductEntity> findPage(int page,int size);
	ProductEntity findtByUrlOne(String url);

	
}
