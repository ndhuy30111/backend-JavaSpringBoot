package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="product")
@Getter
@Setter
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@JsonFormat
public class ProductEntity extends UrlEntitySuper{

	@Column(name = "price",columnDefinition = "bigint(20) default 0 ")
	@Min(value = 1000,message = "Số tiền bán phải trên 1000")
	private Long price;
	@Column(name="discount",columnDefinition = "bigint(20) default 0")
	@Min(value = 1000,message = "Số tiền khuyển mãi trên 10000")
	private Long discount;
	@Column(name="shortIntroduction",nullable = true)
	private String shortIntroduction;
	@Column(name="Introduce")
	private String introduce;
	@OneToMany(mappedBy = "product")
	private List<InvoiceDetailsEntity> invoiceDetails;
	@OneToMany(targetEntity = ColorEntity.class,mappedBy  = "product",cascade=CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	private List<ColorEntity> color;
	@ManyToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private List<CategoryEntity> category;
	@JsonBackReference
	public List<CategoryEntity> getCategory() {
		return category;
	}
	public void setCategory(List<CategoryEntity> category) {
		this.category = category;
	}
	public List<InvoiceDetailsEntity> getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(List<InvoiceDetailsEntity> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	public void setColor(List<ColorEntity> color) {
		this.color = color;
	}

	public String getShortIntroduction() {
		return shortIntroduction;
	}
	public void setShortIntroduction(String shortIntroduction) {
		this.shortIntroduction = shortIntroduction;
	}
	public List<ColorEntity> getColor() {
		return color;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}



	



	
	
}
