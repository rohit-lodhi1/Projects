package com.algorithm;

public class PermutationCombination {

	public static void main(String[] args) {
		String s ="Rohit";
	  stringPermutation(s);
	}
	
	
	public static void stringPermutation(String s) {
		stringPermutation("",s);
	}

	public static void stringPermutation(String permutation,String s) {
		if(s.length()==0)
			System.out.println(permutation);
		else {
			for(int i=0;i<s.length();i++) {
				stringPermutation(permutation+s.charAt(i),s.substring(0,i)+s.substring(i+1,s.length()));
			}
		}
	}
}
