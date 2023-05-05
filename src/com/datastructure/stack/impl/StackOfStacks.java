package com.datastructure.stack.impl;

import java.util.ArrayList;
import java.util.List;

public class StackOfStacks{
	
	private List<FixedSizeArrayStack> listOfStacks = new ArrayList<FixedSizeArrayStack>();
	private int threshold;
	
	public List<FixedSizeArrayStack> getListOfStacks() {
		return listOfStacks;
	}
	
	public int getThreshold() {
		return threshold;
	}
	
	public StackOfStacks(int threshold){
		this.threshold = threshold;
	}
	
	/**
	 * push():
	 * 	- get last stack from list
	 * 	- if null => make newStack and push element in that and add newStack to list
	 * 	- if !=null 
	 * 		=> isFull => make newStack and push element in that and add newStack to list
	 * 	 	=> !isFull => push to last stack
	 */
	public void push(int e) throws StackFullException{
		FixedSizeArrayStack lastStack = getlastStack();
		if(lastStack == null){
			lastStack = new FixedSizeArrayStack(threshold);
			lastStack.push(e);
			listOfStacks.add(lastStack);
		} else {
			if(lastStack.isStackFull()){
				FixedSizeArrayStack newStack = new FixedSizeArrayStack(threshold);
				newStack.push(e);
				listOfStacks.add(newStack);
			} else {
				lastStack.push(e);
			}
		}
	}
	
	/**
	 * pop():
	 * 	- get last stack from list
	 * 	- pop from stack
	 * 	- if last stack is empty now
	 * 	- remove stack from list
	 */
	public int pop() throws StackEmptyException{
		FixedSizeArrayStack lastStack = getlastStack();
		int e = lastStack.pop();
		if(lastStack.isStackEmpty()){
			listOfStacks.remove(lastStack);
		}
		return e;
	}
	
	/**	
	 * popFromNthStack():
	 * 	- get nth stack
	 * 	- pop from stack
	 * 	- if stack is empty now
	 * 	- remove from list
	 */
	public int popFromNthStack(int n) throws StackEmptyException{
		FixedSizeArrayStack nthStack = getNthStack(n);
		int e = nthStack.pop();
		if(nthStack.isStackEmpty()){
			listOfStacks.remove(nthStack);
		}
		return e;
	}
	
	public FixedSizeArrayStack getlastStack(){
		if(listOfStacks.isEmpty()){
			return null;
		} else {
			return listOfStacks.get(listOfStacks.size() - 1);
		}
	}
	
	public FixedSizeArrayStack getNthStack(int n){
		if(listOfStacks.isEmpty()){
			return null;
		} else {
			return listOfStacks.get(n - 1);
		}
	}	
}
