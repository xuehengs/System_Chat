package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.User;
import com.service.UserService;

@Controller
@RequestMapping(value = "/api")
public class TestController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/v1",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> v1(@RequestBody User user){
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
			user.setCreatTime(new Date());
			userService.insert(user);
			map.put("code","1");
			map.put("message","登录成功");
		}else {
			map.put("code","0");
			map.put("message","用户已存在");
		}
		return map;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/test2",method = RequestMethod.POST)
	public void test2(){
		System.out.println("i am test2");
	}


}
