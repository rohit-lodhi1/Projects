package com.algorithm;

public class MergeSort {
 
   static	int b[] = new int[5];
	
	public static void merge(int arr[],int l,int mid,int r) {
	    int i=l,j=mid+1,k=l;
	    
	   while(i<=mid && j<=r) {
		   if(arr[i]<arr[j])
			   b[k++]=arr[i++];
		   else
			   b[k++]=arr[j++];
	   }
	   if(i>mid) {
		   while(j<=r)
			   b[k++]=arr[j++];
	   }
	   else if(j>r) {
		   while(i<=mid)
			   b[k++]=arr[i++];
	   }
	   
	   for(k=l;k<=r;k++) {
		   arr[k]=b[k];
	   }
	    
	}
	
	public static void mergeSort(int arr[],int l,int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}		
	}
		
	public static void mergeSort(int arr[]) {
		mergeSort(arr,0,arr.length-1);
	}
		
	
	public static void main(String [] args) {
		int arr []= {4,1,5,9,0};
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		mergeSort(arr);
		for(int i:b)
			System.out.print(i+" ");
		
	}
}