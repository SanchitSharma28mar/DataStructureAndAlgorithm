package com.datastructure.stack;

import java.util.Stack;

public class Problem_28_RemovingDuplicatesRecursively {
	
	public static Stack<Integer> removeDuplicate(int[] input){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(input[0]);
		for (int i = 0; i < input.length; i++) {
			if(input[i] != stack.peek()){
				stack.push(input[i]);
			}
		}
		return stack;
	}
	
	public static void main(String[] args) {
		int[] input = {1,5,6,8,8,8,0,1,1,0,6,5};
		System.out.println(removeDuplicate(input));
	}
}