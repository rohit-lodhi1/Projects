package com.dataStructure.stack;

public class StackDSA {
    int size=10;
    int i=-1;
    int a[] = new int[size];
    
    public StackDSA(int size) {
    	this.size=size;
    }
    
    public StackDSA() {
    	
    }
    public StackDSA(int a[]) {
    	for(int i:a)
    		push(i);
    }
    
    
    public boolean isEmpty() {
    	return i==-1?true:false;
    }
    
    public boolean isFull() {
    	return i+1==size?true:false;
    }
    
    
    
    public void push(int data) {
      if(!isFull())
    	  a[++i]=data;
      else
    	  System.out.println("Stack is Full");
    }
    
    public int pop(){
    	if(!isEmpty())
    		return a[i--];
    	else
    		System.out.println("Stack is Empty");
    	return -1;
    }
    
    public int peak() {
    	if(!isEmpty())
    		return a[i];
    	else
    		System.out.println("Stack is empty");
    	return -1;
    }
    
    
    public void view() {
    	for(int j=i;j>=0;j--)
    		System.out.println(a[j]);
    }
    public void insertAtBottom(int data) {
    	if(isEmpty())
    	{
           push(data);    		
    		return ;
    	}
    	else
    	{
    		int temp=pop();
    		insertAtBottom(data);
    		push(temp);
    	}
    	
    }
    
    public void stackReverseByRecursion() {
    	if(isEmpty())
    		return ;
    	else {
    		int temp = pop();
    		stackReverseByRecursion();
    		insertAtBottom(temp);
    		
    	}
    }
    
    
    public static void main(String[] args) {
		 StackDSA stack = new StackDSA();
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 
		 stack.view();
         stack.stackReverseByRecursion();
         stack.view();
	}
}
