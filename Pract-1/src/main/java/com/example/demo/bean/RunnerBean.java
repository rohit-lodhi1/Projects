package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component


public class RunnerBean implements CommandLineRunner {
    @Autowired
	private BootBean bb;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
         System.out.println(bb);
	}
}
