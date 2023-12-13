package com.schedular;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.schedular.bean.Schedular;
import com.schedular.config.SchedularConfig;

public class Test {
public static void main(String[] args) throws InterruptedException {
	ApplicationContext ac = new AnnotationConfigApplicationContext(SchedularConfig.class);
	
	Thread.sleep(1000);
}
}
