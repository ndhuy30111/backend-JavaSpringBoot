package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.UserEntity;

@Repository
public interface EntityRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByUserName(String userName);
	UserEntity findOneByEmail(String email);
	
}
