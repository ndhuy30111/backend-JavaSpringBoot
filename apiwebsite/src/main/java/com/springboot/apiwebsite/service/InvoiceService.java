package com.springboot.apiwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.InvoiceDetailsEntity;
import com.springboot.apiwebsite.entity.InvoiceEntity;
import com.springboot.apiwebsite.repository.EntityRepository;
import com.springboot.apiwebsite.repository.InvoiceReponsoty;
import com.springboot.apiwebsite.repository.ProductRepository;
import com.springboot.apiwebsite.service.impl.InvoiceServiceImpl;

@Service
public class InvoiceService implements InvoiceServiceImpl {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EntityRepository entityRepository;
	
	@Autowired
	InvoiceReponsoty invoiceReponsoty;
	
	
		@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public InvoiceEntity save(InvoiceEntity t) {
		// TODO Auto-generated method stub
		return invoiceReponsoty.save(t);
	}


	@Override
	public List<InvoiceEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<InvoiceEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public InvoiceEntity findByIdOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

	


