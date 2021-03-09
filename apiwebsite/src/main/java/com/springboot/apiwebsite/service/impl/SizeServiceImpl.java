package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.SizeEntity;

public interface SizeServiceImpl extends GeneralServiceImpl<SizeEntity>{
	SizeEntity findSize(String productUrl,String colorName,String sizeName);

}
