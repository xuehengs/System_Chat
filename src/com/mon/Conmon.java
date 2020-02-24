package com.mon;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;
@Component
public class Conmon {
	public static String[] imgs = {
			"./static/img/admin.jpg",
			"./static/img/user.jpg",
			"./static/img/user1.jpg",
			"./static/img/user2.jpg",
			"./static/img/user3.jpg",
			"./static/img/user4.jpg",
			"./static/img/user5.jpg",
			"./static/img/user6.jpg",
			};

	public String getToken() {
		StringBuffer sb = new StringBuffer();
		SecureRandom random = new SecureRandom();
		byte seed[] = random.generateSeed(10);
		for(int i=0;i<seed.length;i++)
			sb.append(seed[i]);
		return sb.toString();
	}
	
	
	public static String getImg() {
		int max=7,min=0;
		int i = (int) (Math.random()*(max-min)+min); 
		return imgs[i];
	}
}
