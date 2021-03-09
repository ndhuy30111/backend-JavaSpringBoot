package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.ColorEntity;

public interface ColorServiceImpl extends GeneralServiceImpl<ColorEntity>{
	public ColorEntity findColor(String productUrl,String colorName);
	
}
