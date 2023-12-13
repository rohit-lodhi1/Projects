package com.dollop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dollop.bean.Handler;
import com.dollop.config.MyAppConfig;

public class Test {
	
//	public static void main(String[] args) {
//  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
//     Handler h= ac.getBean("handler",Handler.class);
//     ac.close();
//     System.out.println(h);
//	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
		   Handler h=    ac.getBean("handler",Handler.class);
		   ac.close();
		   System.out.println(h); 
	}
}
