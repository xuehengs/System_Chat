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
	 * 注册用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> register(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		if(user.getUsername()==null||"".equals(user.getUsername())) {
			map.put("code","-1");
			map.put("message","请输入账号");
			return map;
		}
		if(user.getPassword()==null||"".equals(user.getPassword())) {
			map.put("code","-1");
			map.put("message","请输入密码");
			return map;
		}
		if(userService.selectOne(user.getUsername())==0) {
			user.setImg(Conmon.getImg());
			user.setCreatTime(new Date());
			userService.insert(user);
			map.put("code","1");
			map.put("message","注册成功");
		}else {
			map.put("code","0");
			map.put("message","用户已存在");
		}
		return map;
	}
	
	
	
	/**
	 * 登录用户
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
			map.put("message","请输入账号");
			return map;
		}
		else if(user.getPassword()==null||"".equals(user.getPassword())) {
			map.put("code","-1");
			map.put("message","请输入密码");
			return map;
		}
		flag = userService.selectLogin(user);  //减少查询次数，提高效率
		if(flag==1) {
			map.put("code","1");
			map.put("message","登录成功");
			map.put("token",conmon.getToken());
			
		}
		else if(userService.selectOne(user.getUsername())==1 && flag!=1) {
			map.put("code","0");
			map.put("message","密码错误");
		}
		else {
			map.put("code","0");
			map.put("message","登录失败");
		}
		return map;
	}
	
	
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getUser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUser(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		if(user.getUsername()==null && "".equals(user.getUsername())) {
			map.put("code","0");
			map.put("message","没有用户信息");
		}else {
			map.put("user",userService.getUser(user.getUsername()));
		}
		return map;
	}
	
}
