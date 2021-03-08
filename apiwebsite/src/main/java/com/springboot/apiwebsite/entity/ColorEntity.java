package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "color")
public class ColorEntity extends UrlEntitySuper{

	@ManyToOne
	@JoinColumn(columnDefinition = "product_id")
	@JsonBackReference
	private ProductEntity product;
	
	
	
	@OneToMany(targetEntity = SizeEntity.class,mappedBy = "color",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SizeEntity> size;
	@OneToMany(mappedBy = "color")
	private List<UploadFileEntity> image;
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
	public List<UploadFileEntity> getImage() {
		return image;
	}
	public void setImage(List<UploadFileEntity> image) {
		this.image = image;
	}
	
}
