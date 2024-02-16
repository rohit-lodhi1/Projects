package com.java8.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


class Employee{
	private int id;
	private String name;
	private String address;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
//	
}


public class Functions {

	public static void main(String[] args) {
	//	Function<Integer, Integer> f = i ->i*i;  // used as a function here
//		System.out.println(f.apply(5));  
		Predicate<Integer> pre = i -> i%2==0;
		
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(15);
		al.add(25);
		al.add(55);
		al.add(45);
		al.add(35);
		al.add(85);
//		Comparator<Integer> c = (o1,o2)-> o1-o2;
//		Collections.sort(al,c);
//		System.out.println(al);
//		System.out.println(pre.test(10));
		
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee(1,"rohit","bholaram"));
		employee.add(new Employee(3,"sumit","bholaram"));
		employee.add(new Employee(4,"ankit","bholaram"));
		employee.add(new Employee(6,"rahul","bholaram"));
		employee.add(new Employee(2,"vishal","bholaram"));
		
	//	Comparator<Employee> c = (e1,e2) -> e2.getId()-e1.getId();
		Comparator< Employee> c = (e1,e2) -> e1.getName().compareTo(e2.getName());
		Collections.sort(employee,c);
		System.out.println(employee);
	}
	
	
}
