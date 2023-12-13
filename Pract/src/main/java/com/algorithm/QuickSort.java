package com.algorithm;

public class QuickSort {

	public static int divide(int arr[],int start,int end) {
		int pivot = arr[end];
		int i = start-1;
	    for(int j=start;j<end;j++) {
	    	if(pivot>=arr[j])
	    	{
	    		int t = arr[++i];
	    		arr[i]=arr[j];
	    		arr[j]=t;
	    	}
	    }	    
		int t = arr[++i];
		arr[i]=pivot;
		arr[end] = t;
		
		return i;
	}
	public static void sort(int arr[],int start,int end) {
		if(start>=end)                                                                                                                                                                                                                                       
			return;
		int pivot = divide(arr,start,end);
		sort(arr,start,pivot-1);
		sort(arr,pivot+1,end);
	}
	
	public static void quickSort(int arr[]) {
		sort(arr,0,arr.length-1);
		
	}
	public static void main(String[] arg) {
		int arr[] = {1,4,0,2,6,9};
		quickSort(arr);
		for(int i:arr)
			System.out.print(i+" ");
	}

}
