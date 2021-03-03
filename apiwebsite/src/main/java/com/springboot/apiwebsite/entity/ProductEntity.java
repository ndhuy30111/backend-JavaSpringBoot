package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@OneToMany(mappedBy = "product")
	private List<ColorEntity> color;
	@ManyToMany
	@JoinTable(name="catergory_product",joinColumns = @JoinColumn(name="catergory_id"),
	inverseJoinColumns = @JoinColumn (name="product_id"))
	private List<CatergoryEntity> catergory;
	@OneToMany(mappedBy = "product")
	private List<InvoiceDetailsEntity> invoiceDetails;

	
	
	
	public String getShortIntroduction() {
		return shortIntroduction;
	}
	public void setShortIntroduction(String shortIntroduction) {
		this.shortIntroduction = shortIntroduction;
	}
	public List<ColorEntity> getColor() {
		return color;
	}
	public void setColor(List<ColorEntity> color) {
		this.color = color;
	}
	public List<CatergoryEntity> getCatergory() {
		return catergory;
	}
	public void setCatergory(List<CatergoryEntity> catergory) {
		this.catergory = catergory;
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
