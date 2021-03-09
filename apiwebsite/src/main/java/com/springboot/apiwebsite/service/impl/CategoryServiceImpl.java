package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.CategoryEntity;

public interface CategoryServiceImpl extends GeneralServiceImpl<CategoryEntity>{
	CategoryEntity category_prodcut(CategoryEntity t);
}
