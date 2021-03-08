package com.springboot.apiwebsite.service.impl;

import java.util.List;

import com.springboot.apiwebsite.entity.UserEntity;
import com.springboot.apiwebsite.model.UserDto;

public interface UserServiceImpl extends GeneralService<UserEntity>{
	UserEntity getFindUserName(String userName);
	
}
