package com.service;

import java.util.List;

import com.pojo.Friends;
import com.pojo.Message;

public interface MessageService {
	// ����username��ȡ�����б�
	List<String> getFriends(String username);

	// ����Friends��ȡ��Ϣ
	List<Message> getMessage(Friends friends);

	// ������Ϣ
	int sendMessage(Message message);
}
