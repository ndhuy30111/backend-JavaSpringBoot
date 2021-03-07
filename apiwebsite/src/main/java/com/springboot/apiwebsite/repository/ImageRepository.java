package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.ImageEntity;



@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long>{
	
}

