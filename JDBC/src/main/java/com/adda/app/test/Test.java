package com.adda.app.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.adda.app.entity.Address;
import com.adda.app.entity.Employee;
import com.adda.app.service.EmployeeImpl;

public class Test {

	public static void main(String[] args) {
		EmployeeImpl el = new EmployeeImpl();
		Scanner sc = new Scanner(System.in);
//		String s[]={"Indore","Bhopal","Dodar"};
//	List<Employee> empList = Arrays.asList(new Employee("ABC",2000,"Bhopal"),
//			new Employee("DEF",3000,"Madras"),
//			new Employee("GHI",4000,"Lokhandwala"),
//			new Employee("JKL",5000,"Lonawla"),
//			new Employee("MNO",6000,"Jhabua")
//			);
//	
//	//System.out.println(el.addBulkEmployeeByStatement(empList));
       System.out.println(el.UploadImg("C:\\WEB\\images\\undraw_Team_up_re_84ok.png"));
//       int []a;
//       for(int i:a)
       HashMap<Integer, String> a = new HashMap<Integer, String>();
List<Integer> l = List.
       
//      
	/*	Employee emp = new Employee();
		Address as = new Address();
		System.out.println("Entre name ");
		emp.setEmp_name(sc.nextLine());
		System.out.println("Entre salary ");
		emp.setEmp_salary(sc.nextInt());
		System.out.println("Entre work Location ");
		emp.setWorkLocaton(sc.next());
	
		System.out.println("Entre City");
		as.setCity(sc.next());
	
	
		System.out.println("Entre state ");
		
		as.setState(sc.next());
	
		System.out.println("Entre country ");
		as.setCountry(sc.next());
	
		emp.setAddress(as);
		System.out.println(el.addEmp(emp));
		*/
	//	System.out.println(el.getEmp(3));
//		System.out.print(el.EmpFilter("sumit", "200", null));
	//	System.out.println(el.getEmpName("MNO"));
		
	}

}

