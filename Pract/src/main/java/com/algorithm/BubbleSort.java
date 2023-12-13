package com.algorithm;

import java.lang.reflect.Array;

public class BubbleSort {

	
///  <------ Sort int[] in Accending ------>
	
  public static void bubbleSort(int [] arr) {
	  
	  for(int i=0;i<arr.length;i++) {
		  
		  for(int j=0;j<arr.length-i-1;j++) {
			  
			  if(arr[j]>=arr[j+1]) {
				  
				  int t = arr[j];
				  arr[j]=arr[j+1];
				  arr[j+1]=t;
			  }
				  
		  }
	  }
  }
  
///  <------ Sort String[] in Accending ------>
  
  public static String[] bubbleSort(String [] s,int index) throws Exception{
	  if(index==2)
		  return s;
	  else
	  for(int i=0;i<s.length-1;i++) {
	     if(s[i].charAt(index)>s[i+1].charAt(index)) {
	    	 String temp = s[i];
	    	 s[i]= s[i+1];
	    	 s[i+1]=temp;
	     }
	  }
	  s=bubbleSort(s, index+1);
	  return s;
  }
  
  
  
  public static void main(String[] args) {
	  int arr[] = {4,5,1,2};
	  for(int i=0;i<arr.length;i++) {
		  for(int j=0;j<arr.length-i-1;j++) {
			  if(arr[j]>=arr[j+1])
			  {
				  arr[j]=arr[j]+arr[j+1];
				  arr[j+1]=arr[j]-arr[j+1];
				  arr[j]=arr[j]-arr[j+1];
			  }
		  }
	  }
	  for(int a:arr)
		  System.out.print(a);
  	
}

}
