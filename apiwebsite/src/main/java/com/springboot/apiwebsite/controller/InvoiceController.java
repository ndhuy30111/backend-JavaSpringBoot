package com.springboot.apiwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apiwebsite.entity.InvoiceDetailsEntity;
import com.springboot.apiwebsite.entity.InvoiceEntity;
import com.springboot.apiwebsite.service.InvoiceDetailsService;
import com.springboot.apiwebsite.service.InvoiceService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class InvoiceController {
	@Autowired 
	InvoiceService invoiceService;
	@Autowired
	InvoiceDetailsService invoiceDetailsService;
	@PostMapping("/invoice")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody InvoiceEntity invoiceEntity) 
	{
		InvoiceEntity InvoiceNew  =  invoiceService.save(invoiceEntity);
		for (InvoiceDetailsEntity a : InvoiceNew.getInvoiceDetails()) {
			a.setInvoice(InvoiceNew);
			InvoiceDetailsEntity invoiceDetailsServiceNew = invoiceDetailsService.save(a);
			
		}
		 return new ResponseEntity<>(InvoiceNew,HttpStatus.OK);
	}
}
