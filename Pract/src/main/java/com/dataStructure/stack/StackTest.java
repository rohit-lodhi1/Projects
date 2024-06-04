package com.dataStructure.stack;

import java.util.Arrays;
import java.util.function.Predicate;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class StackTest {
	record Person() {}
	
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

		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(30);
		stack.push(80);
		stack.push(20);
		stack.push(40);

//		stack.push(50);
//		stack.print();
//		reverse(stack);
//		stack.print();
//		System.out.println(reverseUsingStack("rohit"));
//		deleteMiddleElement(stack,0,stack.getTop());
//		stack.print();
//		System.out.println(balancedParanthesis("[{((((()))))}]"));
//		stack.print();
//		insertInBottom(stack, 5);
//		stack.print();
//		sortStack(stack, Direction.DESC);
//		stack.print();
//		System.out.println(Character.isAlphabetic('-'));
//		System.out.println(checkRedundancy("((a+b))"));
//		System.out.println(minimumCostToMakeParenthesesValid("}}}}}{"));
//		System.out.println(Arrays.toString(nextSmallerElement(new int[] {2 ,5 ,3 ,7 ,1 ,5 ,2 ,6 ,3 ,1})));
//      System.out.println(Arrays.toString(previousSmallestElement(new int[] {1,3,2,1,4,2})));
//      System.out.println(largestAreaOfRectangleInHistogram(new int[] {1,3,2,1,4,2}));
//		System.out.println(trappingRainWater(new int[] {2,1,0,1,0,1,0,2,0,3,1,2,1,0,1,2}));
//		java.util.Stack<Integer> stackUtil = new java.util.Stack();
//		stackUtil.push(1);
//		stackUtil.push(1);
		System.out.println(largestAreaOfMatrix(new int[][] {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0	}},4));
	}
	
	// used for largest area of rectangle in binary matrix
	public static int[] nextSmallerElementsForLargestRectangle(int arr[]) {
		Stack<Integer> stack =new Stack<>();
		int newArray[] = new int[arr.length];
		stack.push(-1);
        for(int i=arr.length-1;i>=0;i--) {
        	if(arr[i]>stack.peek())
        		newArray[i]=stack.peek();
        	else {
        		while(stack.getTop()>arr[i])
        			stack.pop();
        		newArray[i]=stack.peek();
        	}
        	stack.push(arr[i]);
        }
        return newArray;
	}
	
	// used for largest area of rectangle in binary matrix
	public static int[] prevSmallerElementsForLargestRectangle(int arr[]) {
		Stack<Integer> stack =new Stack<>();
		int newArray[] = new int[arr.length];
		stack.push(-1);
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]>stack.peek())
        		newArray[i]=stack.peek();
        	else {
        		while(stack.getTop()>arr[i])
        			stack.pop();
        		newArray[i]=stack.peek();
        	}
        	stack.push(arr[i]);
        }
        return newArray;
	}
	
	// used for largest area of rectangle in binary matrix
	public static int largestAreaOfRectangleInHistogramBinary(int arr[]) {
		int area=0;
		int nextElements[] = nextSmallerElementsForLargestRectangle(arr);
		int prevElements[] = nextSmallerElementsForLargestRectangle(arr);
		for(int i=0;i<arr.length;i++) {
			int length = arr[i];
			if(nextElements[i]==-1)
				nextElements[i]=arr.length;
			int width = nextElements[i]-prevElements[i]-1;
            int newArea = length*width;
            if(newArea>area)
            	area=newArea;
		}
		return area;
	}
	
	// largest area of rectangle in binary matrix leetcode q.no. 85
	public static int largestAreaOfMatrix(int arr[][],int n) {
		int histogram[]= new int[arr[0].length];
		int area=0;
		for( int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length ;j++) {
				if(arr[i][j]!=0)
					histogram[j]+=arr[i][j];
				else
					histogram[j]=arr[i][j];
			}
			 int newArea = largestAreaOfRectangleInHistogramBinary(histogram);
			 if(newArea>area)
				 area=newArea;
		}
		return area;
	}
	
	public static int previousLargest(int arr[],int i) {
	
		int largest=i-1;
		int value=arr[i];
		i--;
		while(i>=0) {
			if(largest!=-1 && arr[i]>=arr[largest] )
				largest=i;
			if(value<arr[i])
				break;
			i--;
		}
		return largest;
	}
	
	public static int minusFilledBlocks(int arr[],int st,int end,int value,int min) {
		if(st<0)
			return value;
		System.out.println("st = "+st +" end="+end +" value="+value);
		while(st<=end) {
			value-=arr[st];
			System.out.println("arr ="+arr[st]+" value="+value);
		   arr[st]=min;
			st++;
		}
		return value;
	}
	
	//  Trapping Rain Water
	public static int  trappingRainWater(int arr[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			int largest = previousLargest(arr,i);
			
			if(largest==-1)
				continue;
			int value=i-largest-1;
			int minBlock=arr[largest];
		   if(arr[i]<arr[largest])
			   minBlock=arr[i];
		   value=minBlock*value;
		   sum+=minusFilledBlocks(arr, largest+1, i-1, value,minBlock);
		   System.out.println("largest = "+largest+" i = "+i+" value = "+value+" sum = "+sum+" minBlock = "+minBlock);

//		   arr[i]++;
			
		}
		return sum;
	}
	
	
	// for largest area of rectangle in histogram
		public static int[] prevSmallerElementIndex(int arr[]) {
			Stack<Integer> stack= new Stack<>(arr.length);
			int newArray[]=new int[arr.length];
			stack.push(-1);
			for(int i=0;i<arr.length;i++) {
				int val=arr[i];
				if(stack.peek()!=-1 && val>arr[stack.peek()])
					newArray[i]=stack.peek();
				else {
					while(stack.peek()!=-1 && val<=arr[stack.peek()])
						stack.pop();
					newArray[i]=stack.peek();
				}
				stack.push(i);
			}
			return newArray;
		}
	
	// for largest area of rectangle in histogram
	public static int[] nextSmallerElementIndex(int arr[]) {
		Stack<Integer> stack= new Stack<>(arr.length);
		int newArray[]=new int[arr.length];
		stack.push(-1);
		for(int i=arr.length-1;i>=0;i--) {
			int val=arr[i];
			if(stack.peek()!=-1 && val>arr[stack.peek()])
				newArray[i]=stack.peek();
			else {
				while(stack.peek()!=-1 && val<=arr[stack.peek()])
					stack.pop();
				newArray[i]=stack.peek();
			}
			stack.push(i);
		}
		return newArray;
	}
	
	// largest area of rectangle for explanation leetcode ques. 82 - Largest Rectangle in Histogram
	public static int largestAreaOfRectangleInHistogram(int arr[]) {
		 int nextSmallerElements[] = nextSmallerElementIndex(arr);
		 int prevSmallerElements[] = prevSmallerElementIndex(arr);
		 int area=0;
		 for(int i=0;i<arr.length;i++) {
			 int length = arr[i];
			 if(nextSmallerElements[i]==-1)
				 nextSmallerElements[i]=arr.length;
			 // width is the next and prev index between space like how much rectangle can take space
			 int width =  nextSmallerElements[i]-prevSmallerElements[i]-1;
			 // area = length*width
			 int newArea = length*width;
			 if(newArea>area)
				 area=newArea;
		 }
		 return area;
	}
	
	// previous smalles element
	public static int[] previousSmallestElement(int arr[]) {
		Stack<Integer> stack = new Stack<>(arr.length);
		stack.push(-1);
		for(int i=0;i<arr.length;i++) {
		    int val = arr[i];
		    if(val>stack.peek()) {
		    	arr[i]=stack.peek();
		    }else {
		    	while(val<=stack.peek()) {
		    		stack.pop();
		    	}
		    	arr[i]=stack.peek();
		    }
		    stack.push(val);
		}
		return arr;
	}
	
	// next smaller element
	public static int[] nextSmallerElement(int arr[]) {
		int i=arr.length-1,j=arr.length-1;
		int newArray[]=new int[arr.length];
		Stack<Integer> stack = new Stack<>(arr.length+1);
		stack.push(-1);
		while(i>=0) {
			if(arr[i]>stack.peek())
				newArray[j--]=stack.peek();
			else {
				
				while(arr[i]<=stack.peek())
					stack.pop();
				newArray[j--]=stack.peek();
			}
			stack.push(arr[i]);
			i--;
		}
		return newArray;
	}

	
	// minimum cost to make parentheses string  valid
	public static int minimumCostToMakeParenthesesValid(String s) {
		if(s.length()%2!=0)
			return -1;
		int countA=0,countB=0,i=0;
		Stack<Character> stack = new Stack<>();
		while(i<s.length()) {
			char ch = s.charAt(i);
			if(ch=='{') {
				stack.push(ch);
				countA++;
			}
			else {
				if(!stack.isEmpty() && ch=='}' && stack.peek()=='{') {
					stack.pop();
					countA--;
				}else
					countB++;
			}
			i++;
		}
		return ((countA+1)/2 + (countB+1)/2);
	}
	
	
	// minimum parentheses  add to make string valid ex.  input - "(((" , output - 3 
	 public static int minAddToMakeValid(String s) {
	        Stack<Character> stack = new Stack<>(s.length());
	        int count=0,i=0;
	        while(i<s.length()){
	            char ch = s.charAt(i);
	            if(ch=='('){
	                stack.push(ch);
	                count++;
	            }
	            else {
	                
	                if(!stack.isEmpty()&& stack.peek()=='('){
	                    stack.pop();
	                    count--;
	                }else
	                    count++;
	                    
	            }
	            i++;
	        }
	        return count;
	    }
	
	public static boolean isSymbol(Character cha) {
		char ch = cha;
		return ch == '/' || ch == '*' || ch == '-' || ch == '+';
	}

	// check redundant brackets
	public static int checkRedundancy(String s) {
		Stack<Character> stack = new Stack<>(s.length());
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			// add non alphabetic character
			stack.printFromBottom();
			if (!Character.isAlphabetic(ch) && ch != ')')
				stack.push(s.charAt(i));
			else {
				if (ch == ')' && isSymbol(stack.peek())) {
					while (stack.peek() != '(')
						stack.pop();
					stack.pop();

				} else if (ch == ')')
					return 1;
			}
			i++;
		}
		return 0;
	}

	// push value in stack by sorting
	public static <T> void pushBySort(Stack<Integer> stack, Integer data, Direction order) {
		if (stack.isEmpty() || order.equals(Direction.DESC) && stack.peek() >= data
				|| order.equals(Direction.ASC) && stack.peek() <= data) {
			stack.push(data);
			return;
		}
		Integer value = stack.pop();
		pushBySort(stack, data, order);
		stack.push(value);
	}

	// sort a stack
	public static void sortStack(Stack<Integer> stack, Direction order) {
		if (stack.isEmpty())
			return;
		Integer value = stack.pop();
		sortStack(stack, order);
		pushBySort(stack, value, order);
	}

	// insert an element into bottom
	public static <T> void insertInBottom(Stack<T> stack, T value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}

		T val = stack.pop();
		insertInBottom(stack, value);
		stack.push(val);
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
	public static <T> void deleteMiddleElement(Stack<T> stack, int count, int size) {
		if (stack.isEmpty())
			return;

		if (count == size / 2) {
			stack.pop();
			return;
		}
		T value = stack.pop();
		deleteMiddleElement(stack, ++count, size);
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