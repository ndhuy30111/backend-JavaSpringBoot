package com.springboot.apiwebsite.model;

import com.springboot.apiwebsite.entity.UserEntity;

public class UserMapper {
	public static UserDto toUserDto(UserEntity userEntity ){
        UserDto tmp = new UserDto();      
        tmp.setUserName(userEntity.getUserName());
        tmp.setEmail(userEntity.getEmail());
        tmp.setName(userEntity.getName());
        tmp.setStatus(userEntity.isStatus());
        tmp.setCreateBy(userEntity.getCreateBy());
        tmp.setCreateDate(userEntity.getCreateDate());
        tmp.setUpdateBy(userEntity.getUpdateBy());
        tmp.setUpdateDate(userEntity.getUpdateDate());
        return tmp;
    }
}