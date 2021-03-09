package com.springboot.apiwebsite.service.impl;

import com.springboot.apiwebsite.entity.UserEntity;

public interface UserServiceImpl extends GeneralService<UserEntity>{
	UserEntity getFindUserName(String userName);
	
}
