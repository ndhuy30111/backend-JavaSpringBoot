package com.springboot.apiwebsite.entity;

<<<<<<< HEAD
import java.awt.Color;
import java.util.ArrayList;
=======
>>>>>>> 53203080d34f920105ee83891c3e5f135acfd6fd
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
@Entity
@Table(name="product")
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
	@OneToMany(targetEntity = ColorEntity.class,mappedBy  = "product",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ColorEntity> color;
<<<<<<< HEAD
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="catergory_product",joinColumns = @JoinColumn(name="product_id"),
	inverseJoinColumns = @JoinColumn (name="catergory_id"))
	private List<CatergoryEntity> catergory = new ArrayList<>();
=======
	@ManyToMany(mappedBy = "product")
	private List<CategoryEntity> category;
>>>>>>> 53203080d34f920105ee83891c3e5f135acfd6fd
	@OneToMany(mappedBy = "product")
	private List<InvoiceDetailsEntity> invoiceDetails;
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
	public List<CategoryEntity> getCatergory() {
		return category;
	}
	public void setCatergory(List<CategoryEntity> catergory) {
		this.category = catergory;
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
	public String getShortintroduction() {
		return shortIntroduction;
	}
	public void setShortintroduction(String shortintroduction) {
		this.shortIntroduction = shortintroduction;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	
	
}
