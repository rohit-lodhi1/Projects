package com.example.demo.bean;

public class OracleConnection {
private String driver;
private String url;
public String getDriver() {
	return driver;
}
public String geturl() {
	return url;
}	
public void setDriver(String driver) {
	 this.driver=driver;
}
public void seturl(String url) {
	 this.url=url;
}
public OracleConnection() {
	super();
}
@Override
public String toString() {
	return "OracleConnection [driver=" + driver + ", url=" + url + "]";
}
}
