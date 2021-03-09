package com.springboot.apiwebsite.service.impl;

import java.util.List;

public interface GeneralServiceImpl <T>{
	List<T> findAll();
	List<T> findById(Long id);
	T findByIdOne(Long id);
	T save(T t);
	void remove (Long id);
	
}
