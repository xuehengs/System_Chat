package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public int selectOne(String username) {
		return userMapper.selectOne(username);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int selectLogin(User user) {
		return userMapper.selectLogin(user);
	}

	@Override
	public User getUser(String username) {
		return userMapper.getUser(username);
	}

	
	
}
