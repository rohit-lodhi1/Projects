package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PermutationCombination {

	public static void main(String[] args) {
		String s ="abcdef";
	  stringPermutation(s);
	}
	
	
	public static void stringPermutation(String s) {
		List<String> list =new ArrayList<>();
		stringPermutation("",s,list);
		System.out.println(list.size());
	}

	public static void stringPermutation(String permutation,String s,List<String> list) {
		if(s.length()==0)
			list.add(permutation);
		else {
			for(int i=0;i<s.length();i++) {
				stringPermutation(permutation+s.charAt(i),s.substring(0,i)+s.substring(i+1,s.length()),list);
			}
		}
	}
}
