package com.example.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.DbCon;
import com.example.demo.bean.Handler;
import com.example.demo.bean.MyService;
import com.example.demo.bean.OracleConnection;
import com.example.demo.bean.Service;
import com.example.demo.config.myAppConfig;

public class Test {
	
//	public static void main(String[] args) {
//     ApplicationContext ac =new ClassPathXmlApplicationContext("config.xml");
//      Service db=ac.getBean("sob",Service.class);
//     System.out.println(db);
//	}
//
	
	public static void main(String[] args) throws ClassNotFoundException {
		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext("config.xml");
	     Handler db=ac.getBean("handler",Handler.class);
	       System.out.println(db);
	       ac.close();
	       
		}
		
}
 