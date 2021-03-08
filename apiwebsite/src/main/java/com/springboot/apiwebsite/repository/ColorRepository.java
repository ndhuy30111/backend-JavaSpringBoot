package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.ColorEntity;

public interface ColorRepository extends JpaRepository<ColorEntity, Long>{

}
