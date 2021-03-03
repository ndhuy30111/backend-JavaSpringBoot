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
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private InvoiceEntity invoice ;
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product ;
	@Column(name="amount")
	private Integer amount;
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="price")
	private Long price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
