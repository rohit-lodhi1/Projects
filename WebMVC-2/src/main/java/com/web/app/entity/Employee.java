package com.web.app.entity;

import lombok.Data;

@Data
public class Employee {
	private Integer empId;
	private String empName;
	private Double empSal;
	
	private String empPwd;
	private String empDept;
	private String empAddr;
}
