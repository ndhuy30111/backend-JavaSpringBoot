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
	@OneToMany(mappedBy = "color")
	private List<ImageEntity> image;
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
	public List<ImageEntity> getImage() {
		return image;
	}
	public void setImage(List<ImageEntity> image) {
		this.image = image;
	}
	
}
