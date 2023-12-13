package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@ComponentScan(basePackages  = "com.example.demo")
@PropertySource("classpath:myApp.properties")
public class myAppConfig {

}
