package com.test;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class TestMybatisGenerator {
    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
    	UserService userService = (UserService) context.getBean("userService");
    	System.out.println(userService.selectOne("111"));
    }
}
