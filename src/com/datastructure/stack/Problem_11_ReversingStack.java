package com.datastructure.stack;

import java.util.Stack;

public class Problem_11_ReversingStack {
	
	private static Stack<Integer> reverseUsingStack(Stack<Integer> stack){
		Stack<Integer> revStack = new Stack<Integer>();
		while(!stack.isEmpty()){
			revStack.push(stack.pop());
		}
		return revStack;
	}
	public static void main(String[] args) {
		Stack<Integer> mainStack = new Stack<>();
		mainStack.push(0);
		mainStack.push(1);
		mainStack.push(2);
		mainStack.push(3);
		mainStack.push(4);
		mainStack.push(5);
		mainStack.push(6);
		Stack<Integer> reverseStack = reverseUsingStack(mainStack);
		while(!reverseStack.isEmpty()) {
			System.out.print(reverseStack.pop() + " ");
		}
	}
}