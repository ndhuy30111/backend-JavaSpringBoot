package com.springboot.apiwebsite.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "size")
public class SizeEntity extends BasicEntitySuper{
	@Column(name="amount")
	private Integer amount;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "color_id")
	@JsonBackReference
	private ColorEntity color;
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public ColorEntity getColor() {
		return color;
	}
	public void setColor(ColorEntity color) {
		this.color = color;
	}
	
	
	
}
