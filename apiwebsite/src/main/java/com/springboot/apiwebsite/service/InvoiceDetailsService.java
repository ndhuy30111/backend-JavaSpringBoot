package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.InvoiceDetailsEntity;
import com.springboot.apiwebsite.repository.InvoiceDetailsReponsitory;
import com.springboot.apiwebsite.repository.InvoiceReponsoty;
import com.springboot.apiwebsite.service.impl.InvoiceDetailsServiceImpl;

@Service
public class InvoiceDetailsService implements InvoiceDetailsServiceImpl {

	@Autowired
	InvoiceDetailsReponsitory invoiceDetailsReponsitory;

	@Override
	public List<InvoiceDetailsEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceDetailsEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDetailsEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDetailsEntity save(InvoiceDetailsEntity t) {
		// TODO Auto-generated method stub
		return invoiceDetailsReponsitory.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
}
