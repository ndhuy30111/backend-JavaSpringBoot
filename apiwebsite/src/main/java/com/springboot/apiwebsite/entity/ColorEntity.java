package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "color")
public class ColorEntity extends UrlEntitySuper{
	@ManyToOne
	@JoinColumn(columnDefinition = "product_id")
	private ProductEntity product;
	@OneToMany(mappedBy = "color")
	private List<SizeEntity> size;
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public List<SizeEntity> getSize() {
		return size;
	}
	public void setSize(List<SizeEntity> size) {
		this.size = size;
	}
	
	
}
