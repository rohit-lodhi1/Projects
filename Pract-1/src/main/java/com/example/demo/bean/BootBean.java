package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( prefix = "com")

public class BootBean {
//	@Value("${com.name}")
	private String name;
//	@Value("${com.lesson}")
	private String gender;
	//@Value("${com.id}")
	private int id;

	}
