package com.dollop.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Handler {

	@Value("file.txt")
	private String File;
	@Value("C://users")
	private String path;
	public Handler() {
		System.out.println("Construtor");
	}

	@Override
	public String toString() {
		return "Handler [File=" + File + ", path=" + path + "]";
	}

	public String getFile() {
		return File;
	}

	public void setFile(String file) {
		File = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Destory method");
		
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method");
		
	}

}
