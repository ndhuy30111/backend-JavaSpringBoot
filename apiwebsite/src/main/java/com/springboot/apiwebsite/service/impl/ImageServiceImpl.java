package com.springboot.apiwebsite.service.impl;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.apiwebsite.entity.UploadFileEntity;


public interface ImageServiceImpl extends GeneralServiceImpl<UploadFileEntity>{
	String storeFile(MultipartFile file);
	Resource loadFileAsResource(String fileName);
	UploadFileEntity findByIdOne(String id);
}	
