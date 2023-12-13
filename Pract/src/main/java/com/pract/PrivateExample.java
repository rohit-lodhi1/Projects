package com.pract;

public class PrivateExample {
   private String getMessage() {
	   return "This is private Method";
   }
   private  int multiply(int a,int b) {
	   return a*b;
   }
   public static void main(String[] args) {
	CDS a = new CDS();
	System.out.println(a.x);
}
} 

class BCS{
	int x;
BCS(){
	System.out.println();
}
}

class CDS extends BCS{
	CDS(){
		
		System.out.println();
	}
}

