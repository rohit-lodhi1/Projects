package com.classDetails;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class load{
	load(){}
	load(int a,int b){}
	int a,b;
	String ab,bc;
	public void display() {}
	public int show() {return 9;}
	class ab{
		int ab ;
	}
	class abd{
		int ab ;
	}
	
}

public class ClassDetails {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre");
        Class a = Class.forName("com.classDetails."+sc.next());
                       Constructor c[]=a.getDeclaredConstructors();
                       Field f[] = a.getDeclaredFields();
                       Method m[]= a.getDeclaredMethods();
                       Class[] inner=a.getDeclaredClasses();
                       
                       System.out.println(inner.length);
                       System.out.println("Constructors = "+c.length+"\nFields =" + f.length+"\nMethods = "+m.length);
                       
	}

}
