package com.rover.app.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rover.app.bean.DriverManager;
import com.rover.app.config.MyAppConfig;
import com.rover.app.service.DriverManagerService;

public class Test {

	public static void main(String[] args) {
       AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(MyAppConfig.class);
       DriverManagerService dm =ac.getBean("driverManagerService",DriverManagerService.class);
    		  System.out.println(dm);

	}
}
