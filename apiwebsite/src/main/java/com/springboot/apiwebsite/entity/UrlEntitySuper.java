package com.springboot.apiwebsite.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.slugify.Slugify;
import com.springboot.apiwebsite.util.SlugUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntitySuper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name",length = 100,nullable = false)
	@NotNull(message = "Bạn không được để null name")
	private String name;
	@Column
	@CreatedBy
	private String createBy;
	@Column
	@LastModifiedBy
	private String updateBy;
	@Column
	@CreatedDate
	private Date createDate;
	@Column
	@LastModifiedDate
	private Date updateDate;
	@Column(name="status",columnDefinition = "boolean default 1")
	private boolean status ;
	@Column(name="url",columnDefinition = "text")
	private String url ;
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim().replaceAll("( )+", " ");
		this.url = new  Slugify().slugify(name);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = SlugUtil.makeSlug(name);
	}
	
	
}
