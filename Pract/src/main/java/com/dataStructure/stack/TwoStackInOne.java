package com.dataStructure.stack;

public class TwoStackInOne {
	private int size = 10;
	private int top1 = -1;
	private int top2 = size;
	private int stack[] = new int[size];
	
	public TwoStackInOne() {	}
	public TwoStackInOne(int size) {
		this.size=size;
	}

	public void push1(int value) {
		if (this.isFull1())
			throw new RuntimeException("Stack 1 is full");
		stack[++top1] = value;
	}

	public void push2(int value) {
		if (this.isFull2())
			throw new RuntimeException("Stack 2 is full");
		stack[--top2] = value;
	}

	public int pop1() {
		if(this.isEmpty1())
			throw new RuntimeException("Stack 1 is empty");
		return stack[top1--];
	}
	
	public int pop2() {
		if(this.isEmpty2())
			throw new RuntimeException("Stack 2 is empty");
		return stack[top2++];
	}
	
	public int peek1() {
		if (this.isEmpty1())
			throw new RuntimeException("Stack 1 is empty");
		return stack[top1];
	}

	public int peek2() {
		if (this.isEmpty2())
			throw new RuntimeException("Stack 2 is empty");
		return stack[top2];
	}

	public boolean isEmpty1() {
		return top1 == -1;
	}

	public boolean isEmpty2() {
		return top2 == size;
	}

	public boolean isFull1() {
		return top1 + 1 >= top2;
	}

	public boolean isFull2() {
		return top1 + 1 >= top2;
	}
	
	public void print1() {
		for(int i=0;i<=top1;i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	}
	
	public void print2() {
		for(int i=size-1;i>=top2;i--)
			System.out.print(stack[i]+" ");
		System.out.println();
	}
}
