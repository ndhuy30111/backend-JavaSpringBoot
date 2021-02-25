package com.springboot.apiwebsite.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catergory")
public class CatergoryEntity extends UrlEntitySuper{
	@ManyToMany(mappedBy = "catergory")
	private List<ProductEntity> product;
}
