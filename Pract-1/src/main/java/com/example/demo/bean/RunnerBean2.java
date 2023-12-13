package com.example.demo.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component

public class RunnerBean2 implements CommandLineRunner {

	
	@Override
	public void run(String... args) throws Exception {
	  System.out.println("2");

	}

}
