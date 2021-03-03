package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.UserEntity;

public interface UserServiceImpl {
	UserEntity getFindUserName(String userName);
	UserEntity saveUser(UserEntity userEntity);
}
