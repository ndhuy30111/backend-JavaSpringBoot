package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class InvoiceEntity extends BasicEntitySuper{
	@OneToMany(mappedBy = "invoice")
	private List<InvoiceDetailsEntity> invoiceDetails;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	public List<InvoiceDetailsEntity> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetailsEntity> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	
}
