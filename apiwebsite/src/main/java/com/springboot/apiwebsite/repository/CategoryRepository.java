package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.apiwebsite.entity.CategoryEntity;
import com.springboot.apiwebsite.entity.ProductEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	@Query(value="SELECT * FROM category c WHERE c.url = ?1 limit 1",nativeQuery=true)
	CategoryEntity findOneByUrl(String url);
	CategoryEntity findOneByName(String name);
}
