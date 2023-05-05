package com.datastructure.stack;

import java.util.Stack;

public class Problem_07_GetMinimumStackImproved {

	private Stack<Integer> mainStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int e){
		mainStack.push(e);
		if(minStack.isEmpty() || e <= minStack.peek()){
			minStack.push(e);
		}
	}
	
	public int pop(){
		if(mainStack.peek() == minStack.peek()) {
			minStack.pop();
		}
		return mainStack.pop();
	}
	
	public int getMinimum(){
		return minStack.peek();
	}
}
