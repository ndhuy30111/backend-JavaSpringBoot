package com.springboot.apiwebsite.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="uploadFile")
public class UploadFileEntity {
	@Id
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
	@ManyToOne
	@JoinColumn(name="color_id")
	private ColorEntity color;
	
	public UploadFileEntity(String fileName, String fileDownloadUri, String fileType, long size, ColorEntity color) {
		super();
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
		this.color = color;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	
}
