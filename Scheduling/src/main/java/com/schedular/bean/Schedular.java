package com.schedular.bean;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


public class Schedular {
@Scheduled(fixedDelay  = 3000)
	public void show() {
		System.out.println("50% of on sale");
		LocalDateTime localTime = LocalDateTime.now();
		System.out.println(localTime.getSecond());
	}
}
