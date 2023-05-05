package com.datastructure.stack;

import java.util.Stack;

public class Problem_26_StackSorting {
	/**
	 * Idea:
	 * 	Use another stack and push values popped from original stack till values are in order
	 * 	once popped value from original is greater that peek of other stack.
	 * 	pop all which are less from other stack and push to original and push element to other
	 * 	Again pop elements from original to other
	 * 	Keep on repeating till original stack becomes empty
	 * 
	 */
	public static Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> sortedStack = new Stack<Integer>();
		while(!stack.isEmpty()){
			Integer temp = stack.pop();
			// This loop checks the place where the popped(temp) element would go.
			while(!sortedStack.isEmpty() && sortedStack.peek().compareTo(temp) > 0){
				stack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}
		return sortedStack;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(9);
		stack.push(4);
		stack.push(3);
		stack.push(10);
		System.out.println(stack);
		System.out.println(sort(stack));
	}
}
