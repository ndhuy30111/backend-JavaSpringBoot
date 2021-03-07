package com.springboot.apiwebsite.service.impl;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService <T>{
	List<T> findAll();
	List<T> findById(Long id);
	T save(T t) throws SQLException;
	void remove (Long id);
}
