package com.patterns;

public class StarPattern {

	public static void main(String[] args) {
		// hollowSquare(5);
//		rhombus(5);
//		mirroredRhombus(10);
//		pyramid(10);
		hollowPyramid(10);
	}
	
	//Hollow Square Star Pattern
	public static void hollowSquare(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || i==n-1 || j==0||j==n-1)
				System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	// Rhombus Star Pattern
	public static void rhombus(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+n;j++) {
				if(j<=i)
					System.out.print(" ");
					else
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// Mirrored Rhombus
	public static void mirroredRhombus(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2-i;j++) {
				if(j<=n-i-2)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
//	Pyramid Star Pattern
	public static void pyramid(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<n+i;j++) {
		       if(j<=n-i)
		    	   System.out.print(" ");
		       else
		    	   System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// Hollow Pyramid Star Pattern
	public static void hollowPyramid(int n) {
		for(int i=0;i<n;i++) {
			for(int j=1;j<=n+i;j++) {
		       if(j==n-i ||i==n-1 || j==n+i)
		    	   System.out.print("*");
		       else
		       System.out.print(" ");
			}
			System.out.println();
		}
	}
}
