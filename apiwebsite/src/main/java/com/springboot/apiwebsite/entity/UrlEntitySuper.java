package com.springboot.apiwebsite.entity;


import javax.persistence.Column;
import javax.persistence.EntityListeners;

import javax.persistence.MappedSuperclass;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class UrlEntitySuper extends BasicEntitySuper{
	@Column(name="url",columnDefinition = "text")
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
