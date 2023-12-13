package com.dataStructure.stack;

import java.util.Stack;

public class PatternChecker {

	int size = 20;
	char arr[] = new char[size];
	int i = -1;

	public boolean isEmpty() {
		return i == -1 ? true : false;
	}

	public boolean isFull() {
		return i + 1 == size ? true : false;
	}

	public void push(char ch) {
		if (!isFull())
			arr[++i] = ch;
		else
			System.out.println("Stack is full");
	}

public char pop() {
	if (!isEmpty())
		return arr[i--];
	else
		System.out.println("Stack is Empty");
	return ' ';
}

public char peak() {
	if (!isEmpty())
		return arr[i];
	else
		System.out.println("Stack is Empty");
	return ' ';
}

public boolean check(String string) {
	char ch;
	for (int j = 0; j < string.length(); j++) {
		ch = string.charAt(j);

		if (ch == '[' || ch == '{' || ch == '(')
			push(ch);
		else {
			if (isEmpty())
     				return false;

			else if (ch == '}' && peak() != '{')
	    			return false;

			else if (ch == ']' && peak() != '[')
		    		return false;

			else if (ch == ')' && peak() != '(')
			    	return false;

			else
				pop();
		}
	}
	return isEmpty();
}

   public String getAlgorithmn() {
      String s =  "\t\tBalanced Bracket Algo \n\n"+ 
    		  "Step 1.  If opening bracket found push it in the Stack. \n"
      		+    "Step 2.  If closing bracket found check that in top of stack, opening bracket should be present if not than return false. \n"
      		+    "Step 3.  If found then pop()  \n"
            +    "Step 4.  If stack is Empty and no String is left return true \n"
            +    "Step 5.  If stack is Empty and String is left than return false \n"
            +    "Step 6.  At the End return isEmpty()\n";
            
	return s+getCode();
   }
public String getCode() {
	String s = "\n\t\t CODE \n\n"
			+ "public boolean check(String input) {\r\n"
			+ "	char ch;\r\n"
			+ "	for (int j = 0; j < input.length(); j++) {\r\n"
			+ "		ch = input.charAt(j);\r\n"
			+ "\r\n"
			+ "		if (ch == '[' || ch == '{' || ch == '(')\r\n"
			+ "			push(ch);\r\n"
			+ "		else {\r\n"
			+ "			if (isEmpty())\r\n"
			+ "     				return false;\r\n"
			+ "\r\n"
			+ "			else if (ch == '}' && peak() != '{')\r\n"
			+ "	    			return false;\r\n"
			+ "\r\n"
			+ "			else if (ch == ']' && peak() != '[')\r\n"
			+ "		    		return false;\r\n"
			+ "\r\n"
			+ "			else if (ch == ')' && peak() != '(')\r\n"
			+ "			    	return false;\r\n"
			+ "\r\n"
			+ "			else\r\n"
			+ "				pop();\r\n"
			+ "		}\r\n"
			+ "	}\r\n"
			+ "	return isEmpty();\r\n"
			+ "}";
	return s;
}
   
   public  boolean patternChecker(String string) {
	   return     check(string);   
   }
   
   public static void main(String[] args) {
  //PatternChecker pt = new PatternChecker();
  //System.out.println(pt.getAlgorithmn());
	   System.out.println(checkIt("[{}]"));
	   
}
   
   public static boolean checkIt(String s) {
	   Stack<Character> stack = new Stack<>();
	   for(int i=0 ; i<s.length() ; i++) {
		   char ch = s.charAt(i);
		   if(ch=='[' || ch=='{' || ch=='(')
			   stack.push(ch);
		   else
		   {
			   if(stack.peek()!='[' && ch==']'||stack.peek()!='{' && ch=='}'||stack.peek()!='(' && ch==')')
				   return false;

			   stack.pop();
		   }
	   }
	   return stack.size()==0?true:false;
   }
   
   
}
