package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mon.Conmon;
import com.pojo.User;
import com.service.UserService;

@Controller
@RequestMapping(value = "/api/v1")
public class UserController {
  
	@Autowired
	UserService userService;
	@Autowired
	Conmon conmon;
	

	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> register(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		if(user.getUsername()==null||"".equals(user.getUsername())) {
			map.put("code","-1");
			map.put("message","�������˺�");
			return map;
		}
		if(user.getPassword()==null||"".equals(user.getPassword())) {
			map.put("code","-1");
			map.put("message","����������");
			return map;
		}
		if(userService.selectOne(user.getUsername())==0) {
			user.setImg(Conmon.getImg());
			user.setCreatTime(new Date());
			userService.insert(user);
			map.put("code","1");
			map.put("message","ע��ɹ�");
		}else {
			map.put("code","0");
			map.put("message","�û��Ѵ���");
		}
		return map;
	}
	
	
	
	/**
	 * ��¼�û�
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(@RequestBody User user){
		int flag=0;
		Map<String,Object> map = new HashMap<>();
		if(user.getUsername()==null||"".equals(user.getUsername())) {
			map.put("code","-1");
			map.put("message","�������˺�");
			return map;
		}
		else if(user.getPassword()==null||"".equals(user.getPassword())) {
			map.put("code","-1");
			map.put("message","����������");
			return map;
		}
		flag = userService.selectLogin(user);  //���ٲ�ѯ���������Ч��
		if(flag==1) {
			map.put("code","1");
			map.put("message","��¼�ɹ�");
			map.put("token",conmon.getToken());
			
		}
		else if(userService.selectOne(user.getUsername())==1 && flag!=1) {
			map.put("code","0");
			map.put("message","�������");
		}
		else {
			map.put("code","0");
			map.put("message","��¼ʧ��");
		}
		return map;
	}
	
	
	/**
	 * ��ȡ�û���Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getUser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUser(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		if(user.getUsername()==null && "".equals(user.getUsername())) {
			map.put("code","0");
			map.put("message","û���û���Ϣ");
		}else {
			map.put("user",userService.getUser(user.getUsername()));
		}
		return map;
	}
	
}
