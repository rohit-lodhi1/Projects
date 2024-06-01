package com.dataStructure.stack;

public class Stack<T> {
	private int size=10;
	private int top=-1;
	private T[] stack=(T[]) new Object[size]; 

	public Stack(int size) {
		this.size = size;
		stack=(T[]) new Object[this.size];
	}

	public Stack() {}
	
	// push into stack
	public void push(T data) {
		if(this.isFull()) 
			throw new RuntimeException("Stack is full");
		this.stack[++top]=data;
	}
	
	// pop from stack
	public T pop() {
		if(this.isEmpty())
			throw new RuntimeException("Stack is Empty");
		return this.stack[top--];
	}
	
	// view top element of stack
	public T peek() {
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
		if(this.isEmpty()) {
			System.out.println();
			return ;			
		}
		T data = this.pop();
		System.out.print(data+" ");
		print();
		this.push(data);
	}
	
	public void printFromBottom() {
		for(int i=0;i<=top;i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getTop() {
		return this.top;
	}
}
