package com.datastructure.stack;

import java.util.Stack;

public class Problem_02_InfixToPostfix {
	/**
	 * Idea:
	 * divide the string in 4 parts and check in the order
	 * 
	 * isOperand => append to result string
	 * isOpeningBracket => push to stack
	 * isClosingBracket => peek till openingBracket while pop()ing and appending to result string till openingBracket is found 
	 * 						and then pop openingBracket top remove from stack
	 * isOperator => if isEmpty -> push to stack
	 *            => if !isEmpty() => openingBracket is on top -> push new char to stack
	 *            				   => operator is on top -> append pop() to result string and push char to stack
	 * 
	 */
	
	private static Stack<Character> stack = new Stack<>();
	
	public static String convert(String expression){
		String resultantExpression = "";
		for (int i = 0; i < expression.length(); i++) {
			if(!isOpeningBracket(expression.charAt(i)) && !isClosingBracket(expression.charAt(i)) && !isOperator(expression.charAt(i))){
				// character is an operand.
				resultantExpression = resultantExpression + expression.charAt(i);
			} 
			else if(isOpeningBracket(expression.charAt(i))){
				stack.push(expression.charAt(i));
			} 
			else if(isOperator(expression.charAt(i))){
				if(stack.isEmpty()){
					stack.push(expression.charAt(i));
				} 
				else {
					if(isOpeningBracket(stack.peek())){
						stack.push(expression.charAt(i));
					} 
					else {
						resultantExpression = resultantExpression + stack.pop();
						stack.push(expression.charAt(i));
					}
				}
			} 
			else if(isClosingBracket(expression.charAt(i))){
				while(!stack.isEmpty() && !isOpeningBracket(stack.peek())){
					resultantExpression = resultantExpression + stack.pop();
				}
				// Pop the opening bracket if any
				stack.pop();
			}
		}
		if(!stack.isEmpty()){
			resultantExpression = resultantExpression + stack.pop();
		}
		return resultantExpression;
	}
	private static boolean isOpeningBracket(char ch){
		boolean flag = false;
		if(ch == '{' || ch == '(' || ch == '['){
			flag = true;
		}
		return flag;
	}
	private static boolean isClosingBracket(char ch){
		boolean flag = false;
		if(ch == '}' || ch == ')' || ch == ']'){
			flag = true;
		}
		return flag;
	}
	private static boolean isOperator(char ch){
		boolean flag = false;
		if(ch == '+' || ch == '-' || ch == '*'){
			flag = true;
		}
		return flag;
	}
	public static void main(String[] args) {
		System.out.println(convert("A+B"));
		stack.removeAllElements();
		System.out.println(convert("A+B+C"));
		stack.removeAllElements();
		System.out.println(convert("A*B-(C+D)"));
		stack.removeAllElements();
		System.out.println(convert("A*B-(C+D)+E"));
		stack.removeAllElements();
	}
}
