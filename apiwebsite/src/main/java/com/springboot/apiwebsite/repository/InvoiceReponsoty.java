package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.InvoiceEntity;

public interface InvoiceReponsoty extends JpaRepository<InvoiceEntity ,Long> {

}
