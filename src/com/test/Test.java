package com.test;

import java.security.SecureRandom;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		int max=7,min=0;
		int ran2 = (int) (Math.random()*(max-min)+min); 
		System.out.println(ran2);
	}
}
