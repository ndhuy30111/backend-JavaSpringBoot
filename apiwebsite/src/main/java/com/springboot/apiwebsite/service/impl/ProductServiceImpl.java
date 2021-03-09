package com.springboot.apiwebsite.service.impl;

import java.util.List;
import java.util.Optional;

import com.springboot.apiwebsite.entity.ProductEntity;

public interface ProductServiceImpl extends GeneralServiceImpl<ProductEntity>{
	public List<ProductEntity> findPage(int page,int size);
	public ProductEntity findUrl(String url);

}
