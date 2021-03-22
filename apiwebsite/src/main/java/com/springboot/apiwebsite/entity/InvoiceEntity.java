package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "invoice")
public class InvoiceEntity extends BasicEntitySuper{
	@OneToMany(mappedBy = "invoice")
	private List<InvoiceDetailsEntity> invoiceDetails;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	@JsonBackReference
	public List<InvoiceDetailsEntity> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetailsEntity> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
