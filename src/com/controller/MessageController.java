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

import com.pojo.Friends;
import com.pojo.Message;
import com.pojo.User;
import com.service.MessageService;

@Controller
@RequestMapping(value = "/api/v1")
public class MessageController {

	
	@Autowired
	MessageService messageService;

	
	/**
	 * 根据username获取聊天信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "message/getMessage",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getMessage(@RequestBody Friends friends){
		Map<String,Object> map = new HashMap<>();
		List<Message> message =  messageService.getMessage(friends);
		map.put("message",message);
		return map;
	}
	
	
	/**
	 * 发送信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "message/sendMessage",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> sendMessage(@RequestBody Message message){
		Map<String,Object> map = new HashMap<>();
		message.setSendTime(new Date());
		int result =  messageService.sendMessage(message);
		if(result==1) {
			map.put("message","发送成功");
		}else {
			map.put("message","发送失败");
		}
		return map;
	}
}
