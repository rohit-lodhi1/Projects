package com.dataStructure.stack;

public class Stack {
	private int size=10;
	private int top=-1;
	private int stack[]=new int[size]; 

	public Stack(int size) {
		this.size = size;
	}

	public Stack() {}
	
	// push into stack
	public void push(int data) {
		if(this.isFull()) 
			throw new RuntimeException("Stack is full");
		this.stack[++top]=data;
	}
	
	// pop from stack
	public int pop() {
		if(this.isEmpty())
			throw new RuntimeException("Stack is Empty");
		return this.stack[top--];
	}
	
	// view top element of stack
	public int peek() {
		if(this.isEmpty())
			throw new RuntimeException("Stack is Empty");
		return this.stack[top];
	}
	
	// checks if stack is empty or not
	public boolean isEmpty() {
		return this.top==-1;
	}
	
	// checks if stack is full or not
	public boolean isFull() {
		return this.top+1==this.size;
	}
	
	public void print() {
		
		for(int i=0;i<=top;i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	}
}
