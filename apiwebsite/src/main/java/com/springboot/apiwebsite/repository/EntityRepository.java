package com.springboot.apiwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apiwebsite.entity.User;

@Repository
public interface EntityRepository extends JpaRepository<User, Long>{
	User findByUserName(String userName);
}
