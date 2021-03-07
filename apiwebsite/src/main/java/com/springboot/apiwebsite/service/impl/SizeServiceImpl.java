package com.springboot.apiwebsite.service.impl;

import org.springframework.data.jpa.repository.Query;

import com.springboot.apiwebsite.entity.SizeEntity;

public interface SizeServiceImpl extends GeneralService<SizeEntity>{
	
		SizeEntity findSize(String productUrl,String colorName,String sizeName);

}
