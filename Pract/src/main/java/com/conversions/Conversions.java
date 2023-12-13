package com.conversions;

public class Conversions {
	
	public String intToBinary(int n) {
		String s="";
		while(n!=0) {
			int r = n%2;
			n=n/2;
			s=r+s;
		}
		
		return s;
	}
	
	public int power(int n,int pow) {
		int p=1;
		for(int i=1;i<=pow;i++) {
			p=n*p;
		}
		return p;
	}
	
	public int binaryToInt(int binary[]) {
		int n=0,c=0;
		for(int i=binary.length-1;i>=0;i--) {
			
			 n+=binary[i]*power(2,c);
			c++;
		}
		
		return n;
	}
	
	public int intToOctal(int n) {
		String s="";
		while(n!=0) {
			int r=n%8;
			n=n/8;
			s=r+s;
		}
		return Integer.parseInt(s);
	}
	
	public int octalToInt(int octal[]) {
		int n=0,c=0;
		
		for(int i=octal.length-1;i>=0;i--) {
			
			n+=octal[i]*power(8,c++);
			
		}
		
		return n;
	}
	
	
   public static void main(String[] args) {
	  Conversions c  = new Conversions();
	   int [] binary = {1,1,0,0,1,0,0};
	   int n=100;
//	   System.out.println(c.binaryToInt(binary));
//	   System.out.println(Integer.parseInt(c.intToBinary(10)));
    //System.out.println(c.intToOctal(n));
	   System.out.println(c.octalToInt(new int[]{1,4,4}));
   }
}

