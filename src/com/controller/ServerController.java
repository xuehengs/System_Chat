package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


import javax.servlet.http.HttpServletResponse;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONObject;
import com.mon.EchoServerEncoder;
import com.pojo.Message;

/**
 * 该类是WebSocket类，用于发送信息给客户端
 * @author Administrator
 *
 */
@ServerEndpoint(value = "/ws/serverController", encoders = { EchoServerEncoder.class })
public class ServerController{

	private static Collection<ServerController> servers = Collections
			.synchronizedCollection(new ArrayList<ServerController>());
	private Session session;

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		add(this);
	}

	@OnClose
	public void onClose() {
		remove(this);
	}

//	@OnMessage
//	public void onMessage(String msg, Session session) throws IOException, EncodeException {
//		System.out.println("来自客户端的消息:" + msg);
//		System.out.println("我要發送信息");
//		JSONObject jsonObj = new JSONObject(msg);
//		Message message = new Message();
//		message.setUsername(jsonObj.get("username").toString());
//		message.setFriend(jsonObj.get("friend").toString());
//		message.setMessage(jsonObj.get("message").toString());
//		message.setSend_user(jsonObj.get("send_user").toString());
////		Date date = new Date();
////		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ; //使用了默认的格式创建了一个日期格式化对象。
////		String time = dateFormat.format(date); //可以把日期转换转指定格式的字符串
////		message.setSendTime(date);
//		for (Session aSession : session.getOpenSessions()) {
//			aSession.getBasicRemote().sendObject(message);
//		}
//	}

	/**
	 * 这个方法主要用来接收客户端发来的信息msg和响应信息给客户端sendText()
	 * 下面是自定义后的方法
	 * @param msg
	 * @param session
	 * @throws IOException
	 * @throws EncodeException
	 */
	@OnMessage
	public void onMessage(String msg, Session session) throws IOException, EncodeException {
		System.out.println(msg);
		String friend = "{\"friend\":\"" + msg+"\"}";
		for (Session aSession : session.getOpenSessions()) {
			aSession.getBasicRemote().sendText(friend);
		}
	}
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	public static int getTotal() {
		return servers.size();
	}

	public static void add(ServerController server) {
		System.out.println("有新连接加入！ 当前总连接数是：" + servers.size());
		servers.add(server);
	}

	public static void remove(ServerController server) {
		System.out.println("有连接退出！ 当前总连接数是：" + servers.size());
		servers.remove(server);
	}

}
