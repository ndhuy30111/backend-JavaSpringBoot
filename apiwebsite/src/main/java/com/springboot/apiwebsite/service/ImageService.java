package com.springboot.apiwebsite.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apiwebsite.entity.ImageEntity;
import com.springboot.apiwebsite.repository.ImageRepository;
import com.springboot.apiwebsite.service.impl.ImageServiceImpl;

@Service
public class ImageService implements ImageServiceImpl{

	@Autowired
	private ImageRepository imageRepository;
	@Override
	public List<ImageEntity> findAll() {

		return imageRepository.findAll();
	}

	@Override
	public List<ImageEntity> findById(Long id ) {
		
		return null;
	}

	@Override
	public ImageEntity save(ImageEntity t) {
		// TODO Auto-generated method stub
		return imageRepository.save(t);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		imageRepository.deleteById(id);
	}
	
	


	 

	

}
