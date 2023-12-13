package com.example.demo.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Handler  {
	@Value("bye")
	private String file;
	@Value("hello")
	private String mode;

public Handler() {
	System.out.println("Constructor");
}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		System.out.println("Set file");
		this.file = file;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Handler [file=" + file + ", mode=" + mode + "]";
	}
	@PostConstruct
	public void setup() throws Exception {
		System.out.println("Init method");
	}
	
@PreDestroy
	public void clean() throws Exception {
		System.out.println("Destroying method");
	}

	
}
