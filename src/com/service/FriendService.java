package com.service;

import java.util.List;

import com.pojo.Friends;
import com.pojo.User;

public interface FriendService {
	// ����username��ȡ�����б�
	List<User> getFriends(String username);

	// ��Ӻ���
	int insert(Friends record);

	// �Ƿ���ڸú��ѹ�ϵ
	int isFriend(Friends record);
}
