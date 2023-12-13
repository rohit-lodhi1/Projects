package com.algorithm;

public class SelectionSort {
   
	public static void selectionSort(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			
			int smallest = i;
			
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[smallest]>=arr[j]) {
					smallest = j;
				}
			}
			int t = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = t;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,4,2,5,7,0};
		selectionSort(arr);
		for(int i:arr)
			System.out.print(i+" ");
	}
}
