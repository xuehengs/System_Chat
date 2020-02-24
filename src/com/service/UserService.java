package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.User;

public interface UserService {

	// �ж��û��Ƿ����
	int selectOne(String username);

	// ����û�
	int insert(User record);

	// ��¼
	int selectLogin(User user);
	
	//��ȡ�û���Ϣ
    User getUser(@Param("username")String username);

}
