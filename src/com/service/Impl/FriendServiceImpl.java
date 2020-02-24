package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.FriendsMapper;
import com.pojo.Friends;
import com.pojo.User;
import com.service.FriendService;

@Service("friendsService")
public class FriendServiceImpl implements FriendService{
	@Autowired
	FriendsMapper friendMapper;
	
	@Override
	public List<User> getFriends(String username) {
		return friendMapper.getFriends(username);
	}

	@Override
	public int insert(Friends record) {
		return friendMapper.insert(record);
	}

	@Override
	public int isFriend(Friends record) {
		return friendMapper.isFriend(record);
	}



}
