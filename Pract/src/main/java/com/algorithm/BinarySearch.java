package com.algorithm;

import java.util.Arrays;

public class BinarySearch {

	
	/*
	 * public static int binarySearch(int arr[],int n) { int
	 * li=0,hi=arr.length-1,mid=(li+hi)/2;
	 * 
	 * while(li <= hi) { if(arr[mid]==n) return mid; else if(arr[mid] < n) li=mid+1;
	 * else hi = mid-1; mid = (li+hi)/2; } return 0;
	 * 
	 * }
	 */
	
	
	public static void main(String[] args) {
		
	 System.out.println( binarySearch(new int[] {0},1));	
	}
	
	
	
	
	
	
	
	
	public static boolean binarySearch(int arr[],int value) {
		
	int left=0,right=arr.length;
	while(left<right) {
		
		int mid = (right + left)/2;
		if(arr[mid]==value)
			return true;
		if(arr[mid]<value)
			left=mid+1;
		else
			right = mid;
		
	}
		return false;
	}
	
	
	
	
	
	
	
}
