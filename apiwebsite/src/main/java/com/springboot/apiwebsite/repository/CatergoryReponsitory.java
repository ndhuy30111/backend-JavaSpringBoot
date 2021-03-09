package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.CatergoryEntity;

@Repository
public interface CatergoryReponsitory extends JpaRepository<CatergoryEntity, Long>{

}
