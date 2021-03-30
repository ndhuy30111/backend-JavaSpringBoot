package com.springboot.apiwebsite.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "color")
public class ColorEntity extends UrlEntitySuper{


	@Column(name="code")
	private String code;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = "product_id")
	@JsonIgnore
	private ProductEntity product;
	@OneToMany(targetEntity = SizeEntity.class,mappedBy = "color",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SizeEntity> size;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="color_image",joinColumns = @JoinColumn(name="color_id"),
	inverseJoinColumns = @JoinColumn (name="image_id"))
	private List<UploadFileEntity>image = new ArrayList<>();
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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
