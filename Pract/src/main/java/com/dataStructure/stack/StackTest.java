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

		Stack<Integer> stack = new Stack<>(4);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
//		stack.push(50);
		stack.print();
//		reverse(stack);
//		stack.print();
//		System.out.println(reverseUsingStack("rohit"));
//		deleteMiddleElement(stack,0);
//		stack.print();
		System.out.println(balancedParanthesis("[{()()[[]]}]"));
	}

	// check the balanced paranthysis
	public static boolean balancedParanthesis(String value) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(')
				stack.push(ch);
			else if (ch == '}' && stack.peek() != '{' || ch == ']' && stack.peek() != '['
					|| ch == ')' && stack.peek() != '(')
				return false;
			else
				stack.pop();
		}
		return stack.isEmpty();
	}

	// delete middle element from stack ** make sure that stack is full **
	public static <T> void deleteMiddleElement(Stack<T> stack, int count) {
		if (stack.isEmpty())
			return;

		if (count == stack.getSize() / 2) {
			stack.pop();
			return;
		}
		T value = stack.pop();
		deleteMiddleElement(stack, ++count);
		stack.push(value);
	}

	// reverse string using stack
	public static String reverseUsingStack(String s) {
		Stack<Character> stack = new Stack<>(s.length());
		String response = "";
		for (int i = 0; i < s.length(); i++)
			stack.push(s.charAt(i));

		while (!stack.isEmpty())
			response += stack.pop();

		return response;
	}

	// we will empty the stack and insert every element in bottom
	public static <T> void reverse(Stack<T> stack) {
		if (stack.isEmpty())
			return;
		T val = stack.pop();
		reverse(stack);
		insertIntoBottom(stack, val);
	}

	// inserting element in bottom if stack is not empty then poping the element and
	// after inserting, putting the element back
	public static <T> void insertIntoBottom(Stack<T> stack, T value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		T val = stack.pop();
		insertIntoBottom(stack, value);
		stack.push(val);
	}

}