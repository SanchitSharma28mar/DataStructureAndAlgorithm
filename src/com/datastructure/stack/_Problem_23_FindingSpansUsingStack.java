package com.datastructure.stack;

import java.util.Stack;

public class _Problem_23_FindingSpansUsingStack {
	public static int[] findingSpans(int[] input){
		int[] span = new int[input.length];
		span[0] = 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(input[0]);
		for (int i = 1; i < input.length; i++) {
			if(stack.peek() < input[i]){
				int counter = 1;
				while(!stack.isEmpty() && stack.peek() < input[i]){
					counter++;
					stack.pop();
				}
				span[i] = counter;
				stack.push(input[i]);
			} else {
				span[i] = 1;
				stack.push(input[i]);
			}
		}
		return span;
	}
	public static void main(String[] args) {
		int[] input = {100,65,70,110,80,90,120};
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		int[] output = findingSpans(input);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}
