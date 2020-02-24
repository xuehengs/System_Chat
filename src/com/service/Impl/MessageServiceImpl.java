package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.MessageMapper;
import com.pojo.Friends;
import com.pojo.Message;
import com.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageMapper messageMapper;

	@Override
	public List<String> getFriends(String username) {
		return messageMapper.getFriends(username);
	}

	@Override
	public List<Message> getMessage(Friends friends) {
		return messageMapper.getMessage(friends);
	}

	@Override
	public int sendMessage(Message message) {
		return messageMapper.sendMessage(message);
	}

}
