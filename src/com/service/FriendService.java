package com.service;

import java.util.List;

import com.pojo.Friends;
import com.pojo.User;

public interface FriendService {
	// 根据username获取好友列表
	List<User> getFriends(String username);

	// 添加好友
	int insert(Friends record);

	// 是否存在该好友关系
	int isFriend(Friends record);
}
