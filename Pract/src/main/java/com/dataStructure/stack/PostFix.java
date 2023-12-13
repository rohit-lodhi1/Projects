package com.dataStructure.stack;

public class PostFix {

	public static void main(String[]args) {
		String infix="A-(B*C-D)/E";
		System.out.println(toPostFix(infix));
		
	}
	
	static char stack[]=new char[20];
	static int  size=-1;
	
	static boolean isEmpty() {
		if(size==-1)
			return true;
		return false;
	}
	
	static boolean isFull() {
		if(size+1==stack.length)
			return true;
		return false;
	}
	
	
	
	
	static void push(char ch) {
	  if(!isFull()) 
		  stack[++size]=ch;
	  else
		  System.out.println("Stack Is full");
	}
	
	static char pop() {
		if(!isEmpty())
			return stack[size--];
		return '$';
	}
	
	static int priorty(char ch) {
		switch(ch) {
		case '/':
		case '*':
		case '%': return 2;
		case '+': return 1;
		case '-':return 1;
		}
	
		return 0;
	}
	
	static boolean isNumber(char ch) {
		if(ch>='0' && ch<='9'||ch>='a' && ch<='z' || ch>='A' && ch<='Z')
			return true;
		return false;
	}
	static boolean isSign(char ch) {
		if(ch=='/' || ch=='*' ||ch=='-' || ch=='+' || ch=='%' )
			return true;
		return false;
	}
	
	static char peak() {
		if(!isEmpty()) {
			return stack[size];
		}
	
		return '$';
	}
	
	public static String toPostFix(String infix) {
	   char infi[] = infix.toCharArray();
	   char postFix[] = new char[infi.length];
	   int i=0,j=0;
	   
		while(i+1<=infi.length) {
			char symbol = infi[i++];
			if(isNumber(symbol)) {
                  postFix[j++]=symbol;
			}
			if(isSign(symbol)) {
					 
					 while(priorty(peak())>=priorty(symbol) && !isEmpty()) {
						 postFix[j++]=pop();
					 }
					 push(symbol);
				 
			}
			if(symbol=='(') {
				push(symbol);
			}
			if(symbol==')')
			{
				while(peak()!='(')
					postFix[j++]=pop();
				pop();
			}
			
			
		}
		while(!isEmpty()) {
			postFix[j++]=pop();
		}
		for(char ch:postFix)
			System.out.print(ch);
		
		return null;
	}
}
