package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
}
