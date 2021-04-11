package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@Entity
@Table(name = "category")
public class CategoryEntity extends UrlEntitySuper{
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="category_product",joinColumns = @JoinColumn(name="category_id"),
	inverseJoinColumns = @JoinColumn (name="product_id"))

	private List<ProductEntity> product;

	
	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}





	
	
}
