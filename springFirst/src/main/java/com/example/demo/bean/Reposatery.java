package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Reposatery {

private String entity;

public String getEntity() {
	
	return entity;
}

public void setEntity(String entity) {
	this.entity = entity;
}

@Override
public String toString() {
	return "Reposatery [entity=" + entity + "]";
}

}
