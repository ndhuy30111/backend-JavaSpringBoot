package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.InvoiceDetailsEntity;

public interface InvoiceDetailsReponsitory extends JpaRepository<InvoiceDetailsEntity, Long>{

}
