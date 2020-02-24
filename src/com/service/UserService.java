package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.User;

public interface UserService {

	// 判断用户是否存在
	int selectOne(String username);

	// 添加用户
	int insert(User record);

	// 登录
	int selectLogin(User user);
	
	//获取用户信息
    User getUser(@Param("username")String username);

}
