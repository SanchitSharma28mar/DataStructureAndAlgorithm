package com.datastructure.stack;

import java.util.Stack;

public class Problem_06_GetMinimumStack {
	
	private Stack<Integer> mainStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int e){
		mainStack.push(e);
		if(minStack.isEmpty() || e <= minStack.peek()){
			minStack.push(e);
		} else {
			minStack.push(minStack.peek());
		}
	}
	public int pop(){
		minStack.pop();
		return mainStack.pop();
	}
	public int getMinimum(){
		return minStack.peek();
	}
}
