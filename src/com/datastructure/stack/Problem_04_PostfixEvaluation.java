package com.datastructure.stack;

import java.util.Stack;

public class Problem_04_PostfixEvaluation {
	/**
	 * Idea:
	 * 	divide expression in 2 parts
	 * 	isNumber => push to stack
	 * 	isOperator => pop() two elements, apply operator and push result back
	 * 
	 */
	static Stack<Integer> stack = new Stack<>();
	public static Integer evaluate(String expression){
		for (int i = 0; i < expression.length(); i++) {
			if(!isOperator(expression.charAt(i))){
				stack.push(Integer.parseInt(expression.charAt(i)+""));
			} else {
				Integer a = Integer.parseInt(stack.pop()+"");
				Integer b = Integer.parseInt(stack.pop()+"");
				Integer c = util(a,b,expression.charAt(i));
				stack.push(c);
			}
		}
		return stack.pop();
	}
	private static Integer util(Integer a, Integer b, char operator) {
		Integer res = null;
		switch (operator) {
		case '+':
			res = b+a;
			break;
		case '-':
			res = b-a;
			break;
		case '*':
			res = b*a;
			break;
		case '/':
			res = b/a;
			break;
		default:
			break;
		}
		return res;
	}
	private static boolean isOperator(char ch){
		boolean flag = false;
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
			flag = true;
		}
		return flag;
	}
	public static void main(String[] args) {
		System.out.println("Evaluating 123*+5- : " + evaluate("123*+5-"));
		stack.removeAllElements();
		System.out.println("Evaluating 231*+9- : " + evaluate("231*+9-"));
		stack.removeAllElements();
	}
}
