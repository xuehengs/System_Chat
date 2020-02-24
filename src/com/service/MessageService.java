package com.service;

import java.util.List;

import com.pojo.Friends;
import com.pojo.Message;

public interface MessageService {
	// 根据username获取好友列表
	List<String> getFriends(String username);

	// 根据Friends获取信息
	List<Message> getMessage(Friends friends);

	// 发送信息
	int sendMessage(Message message);
}
