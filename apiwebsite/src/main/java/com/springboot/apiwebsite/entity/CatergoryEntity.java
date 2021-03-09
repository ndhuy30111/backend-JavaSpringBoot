package com.springboot.apiwebsite.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catergory")
public class CatergoryEntity extends UrlEntitySuper {
	@ManyToMany(mappedBy = "catergory", targetEntity = ProductEntity.class)
	private List<ProductEntity> product = new ArrayList<>();

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}

}
