package com.datastructure.stack;

import java.util.Stack;

public class Problem_27_PairConsecutive {
	/**
	 * Idea:
	 * 	pop two elements and check their difference
	 * 
	 */
	public static boolean ifPairConsecutive(Stack<Integer> stack){
		boolean flag = false;
		Stack<Integer> revStack = new Stack<Integer>();
		while(!stack.isEmpty()){
			revStack.push(stack.pop());
		}
		if(revStack.size() % 2 != 0){
			revStack.pop();
		}
		while(!revStack.isEmpty()){
			Integer one = revStack.pop();
			Integer two = revStack.pop();
			Integer diff = one - two;
			if(one<0 && two<0){
				diff = one - (two);
			}
			if(diff == -1 || diff == 1){
				flag = true;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(5);
		stack.push(-2);
		stack.push(-3);
		stack.push(11);
		stack.push(10);
		stack.push(5);
		stack.push(6);
		stack.push(20);
		System.out.println(ifPairConsecutive(stack));
	}
}
