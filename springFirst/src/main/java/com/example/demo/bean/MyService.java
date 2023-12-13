package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

	@Autowired
	private DbCon db;
	    
	@Override
	public String toString() {
		return "MyService [db=" + db + "]";
	}
	
}
