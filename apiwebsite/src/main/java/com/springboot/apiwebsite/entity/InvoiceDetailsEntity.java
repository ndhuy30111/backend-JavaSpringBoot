package com.springboot.apiwebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoicedetails")
public class InvoiceDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private InvoiceEntity invoice ;
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product ;
	@Column(name="amount")
	private Integer amount;
	@Column(name="price")
	private Long price;
	public void setId(Long id) {
		this.id = id;
	}
	
	public InvoiceEntity getInvoice() {
		return invoice;
	}
	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	
	
}
