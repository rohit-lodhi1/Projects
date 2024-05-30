package com.dataStructure.stack;

public class StackTest {
	public static void main(String[] args) {
//        Stack stack = new Stack();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push(40);
//        stack.push(50);
//        stack.print();
//        stack.pop();
//        stack.pop();
//        stack.print();
//		TwoStackInOne stack = new TwoStackInOne();
//		
//		stack.push1(10);
//		stack.push1(20);
//		stack.push1(30);
//		stack.push1(40);
//		stack.push1(50);
//		stack.push1(50);
//		
//		stack.push2(100);
//		stack.push2(90);
//		stack.push2(80);
//		stack.push2(70);
////		stack.push2(60);
//		
//		stack.print1();
//		stack.print2();

		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.print();
		reverse(stack);
		stack.print();

	}

	// we will empty the stack and insert every element in bottom
	public static void reverse(Stack stack) {
		if (stack.isEmpty())
			return;
		int val = stack.pop();
		reverse(stack);
		insertIntoBottom(stack, val);
	}

	// inserting element in bottom if stack is not empty then poping the element and
	// after inserting putting the element back
	public static void insertIntoBottom(Stack stack, int value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		int val = stack.pop();
		insertIntoBottom(stack, value);
		stack.push(val);
	}

}
