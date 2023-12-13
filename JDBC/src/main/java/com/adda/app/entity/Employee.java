package com.adda.app.entity;

public class Employee {
    private int emp_id;
    private String emp_name;
    private int emp_salary;
    private String workLocaton;
    private String joinDate;
    private Address address;
   
    
    
	public String getWorkLocaton() {
		return workLocaton;
	}



	public void setWorkLocaton(String workLocaton) {
		this.workLocaton = workLocaton;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public int getEmp_id() {
		return emp_id;
	}



	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}



	public String getEmp_name() {
		return emp_name;
	}



	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}



	public int getEmp_salary() {
		return emp_salary;
	}



	public void setEmp_salary(int i) {
		this.emp_salary = i;
	}





	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", workLocaton="
				+ workLocaton + ", joinDate=" + joinDate + ", address=" + address + "]";
	}



	public String getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}



	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee( String emp_name, int emp_salary, String workLocaton) {
		super();
	
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.workLocaton = workLocaton;
	
	
	}



}
