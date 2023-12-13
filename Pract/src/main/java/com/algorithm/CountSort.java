package com.algorithm;

public class CountSort {
   public static int findMax(int a[]) {
	   int max=a[0];
	   for(int i=0;i<a.length;i++) {
		   if(max<a[i])
			   max=a[i];
	   }
	   return max;
   }
	
	
	public static void countSort(int a[]) {
	   int max = findMax(a),val=0;
	   int outPut[] = new int[max+1];
	   
	   for(int i=0;i<outPut.length;i++)
		   outPut[i]=0;
	   
	   for(int j=0;j<a.length;j++) {
		   val=outPut[a[j]];
		   outPut[a[j]]=val+1;
	   }
	   
	   int j=0,c=0;
	   for(int k=0;c<outPut.length;k++) {
		   
		   if(outPut[c]>0) {
			   a[j++]=c;
			   val=outPut[c];
			   outPut[c]=val-1;
		   }
		   else
			   c++;
	   }  
    }
	
	public static void main(String[] args) {
		int a[] = {9,3,8,4,5,7,4,2,4,1,3,6,5,9,14,12,3,4};
		for(int i:a)
			System.out.print(i+" ");
		countSort(a);
		 
		System.out.println();
		for(int i:a)
			System.out.print(i+" ");
		
	}
}
