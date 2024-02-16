package com.java8.features;

@FunctionalInterface
interface Functional{
	public static int hello(int n) {
		return n*n;
	}
	
	public int squareA(int n);
	
	default int square(int n) {
		return n*n;
	}
	
}

@FunctionalInterface
interface B extends Functional{
	public int squareA(int a);
}

interface C {
	public int m1();
	public int m2(int n);
	private int m3() {
		return 9;
	}
	private void m4() {
		m3();
	}
}

 class A implements Functional{

	@Override
	public int squareA(int n) {
		
		return 0;
	}

}

public class Interfaces {
   public static void main(String[] args) {
	Functional ex = (n) -> n*n;
	
	System.out.println(ex.squareA(5));
	
}
}
