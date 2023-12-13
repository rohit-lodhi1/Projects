package com.rover.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.rover.app.bean.DriverManager;


///----configuration step------
@Configuration
@ComponentScan("com.rover.app")
@PropertySource("classpath:app.properties")
public class MyAppConfig {
	@Autowired
	public Environment env;
	 /// ----- one method equals on object----
	                                             /// creates class of method name
	
	@Bean
	@Primary
     public DriverManager connectionObj() {
    	 DriverManager dm =new DriverManager(); 
    	 dm.setDriverClass("1 drivern");
    	 dm.setUrl(env.getProperty("my.url"));
    	 System.out.println("1");
    	 return dm;
     }
	@Bean
    public DriverManager connectionObj2() {
   	 DriverManager dm =new DriverManager(); 
   	 dm.setDriverClass(env.getProperty("my.driver.class"));
   	 dm.setUrl(env.getProperty("my.url"));
   	System.out.println("2");
   	 return dm;
    }

}
