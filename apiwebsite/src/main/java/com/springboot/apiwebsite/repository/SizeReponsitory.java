package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.SizeEntity;

@Repository
public interface SizeReponsitory extends JpaRepository<SizeEntity, Long>{
	
	@Query(value ="SELECT s FROM size s JOIN color c ON s.color_id = c.id JOIN product p ON c.product_id = p.id WHERE s.name=?1 and c.name = ?2 and p.url=?3 ",nativeQuery = true)
	public	SizeEntity findBySize(String size,String color,String product);
}
