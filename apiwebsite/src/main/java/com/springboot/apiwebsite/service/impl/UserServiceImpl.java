package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.UserEntity;

public interface UserServiceImpl extends GeneralServiceImpl<UserEntity>{
	UserEntity getFindUserName(String userName);
	
}
