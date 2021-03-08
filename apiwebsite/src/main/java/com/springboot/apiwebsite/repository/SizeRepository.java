package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apiwebsite.entity.SizeEntity;

public interface SizeRepository extends JpaRepository<SizeEntity, Long>{

}
