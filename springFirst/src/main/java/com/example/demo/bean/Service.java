package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Service {

private Reposatery repo;

@Override
public String toString() {
	return "Service [repo=" + repo + "]";
}

public Reposatery getRepo() {
	System.out.println("repo getter");
	return repo;
	
}

public void setRepo(Reposatery repo) {
	System.out.println("repo setter");
	this.repo = repo;
}
}
