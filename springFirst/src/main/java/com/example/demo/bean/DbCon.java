package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbCon {
	@Value("${my.db.key}")
	private int key;
	@Value("${my.db.value}")
	private String value;
	
	@Value("${my.db.driver}")
	private String driver;
	@Value("${my.db.url}")
	private String url;
	@Value("${my.db_user}")
	private String user;
	@Value("${my.db-psw}")
	private String psw;
	@Override
	public String toString() {
		return "DbCon [key=" + key + ", value=" + value + ", driver=" + driver + ", url=" + url + ", user=" + user
				+ ", psw=" + psw + "]";
	}
	
 	

}
