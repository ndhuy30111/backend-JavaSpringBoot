package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.UploadFileEntity;

public interface ImageRepository extends JpaRepository<UploadFileEntity, String>{

}
