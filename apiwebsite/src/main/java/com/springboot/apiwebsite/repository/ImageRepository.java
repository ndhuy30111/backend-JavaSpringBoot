package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

}
