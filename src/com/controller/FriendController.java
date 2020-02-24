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
import com.pojo.User;
import com.service.FriendService;
import com.service.UserService;

@Controller
@RequestMapping(value = "/api/v1")
public class FriendController {

	@Autowired
	FriendService friendService;
	@Autowired
	UserService userService;
	/**
	 * 根据username获取好友列表
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getFriends",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getFriends(@RequestBody User user){
		Map<String,Object> map = new HashMap<>();
		List<User> friends =  friendService.getFriends(user.getUsername());
		map.put("friends",friends);
		return map;
	}
	
	
	/**
	 * 添加好友
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addFriend",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addFriend(@RequestBody Friends friend){
		Map<String,Object> map = new HashMap<>();
		if(friend.getFriend()==null||"".equals(friend.getFriend())) {
			map.put("code","-1");
			map.put("msg","请输入账号");
			return map;
		}
		if(userService.selectOne(friend.getFriend())==0) {
			map.put("code","0");
			map.put("msg","用户不存在");
			return map;
		}
		if(friendService.isFriend(friend)==1) {
			map.put("code","0");
			map.put("msg","你们已是好友关系");
			return map;
		}
		int result =  friendService.insert(friend);
		if(result>0) {
			map.put("code","1");
			map.put("msg","添加成功");
		}else {
			map.put("code","0");
			map.put("msg","添加失败");
		}
		return map;
	}
}
