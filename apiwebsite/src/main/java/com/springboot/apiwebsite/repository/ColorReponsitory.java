package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.ColorEntity;

@Repository
public interface ColorReponsitory extends JpaRepository<ColorEntity, Long> {

}
