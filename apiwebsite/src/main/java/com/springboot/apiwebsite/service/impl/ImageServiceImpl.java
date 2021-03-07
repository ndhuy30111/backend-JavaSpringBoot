package com.springboot.apiwebsite.service.impl;

import java.util.List;

import com.springboot.apiwebsite.entity.ImageEntity;

public interface ImageServiceImpl extends GeneralService<ImageEntity>{
    public List<ImageEntity> findAll();
    public List<ImageEntity> findById(Long id);
    public ImageEntity save(ImageEntity t );
}	
