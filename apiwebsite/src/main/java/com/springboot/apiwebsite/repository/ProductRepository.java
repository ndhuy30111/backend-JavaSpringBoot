package com.springboot.apiwebsite.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.ProductEntity;
@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
	Page<ProductEntity> findAll(Pageable pageble);
	@Query(value="SELECT * FROM product p WHERE p.url = ?1 limit 1",nativeQuery=true)
	ProductEntity findOneByUrl(String url);
}
