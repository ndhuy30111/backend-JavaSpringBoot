package com.springboot.apiwebsite.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class ImageEntity extends UrlEntitySuper{
	@ManyToOne
	@JoinColumn(name="color_id")
	private ColorEntity color;
	
	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}
}
