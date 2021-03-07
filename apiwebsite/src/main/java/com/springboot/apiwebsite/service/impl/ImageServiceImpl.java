package com.springboot.apiwebsite.service.impl;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface ImageServiceImpl {
	String storeFile(MultipartFile file);
	Resource loadFileAsResource(String fileName);
}	
