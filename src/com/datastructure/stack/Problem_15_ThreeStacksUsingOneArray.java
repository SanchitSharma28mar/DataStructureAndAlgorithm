package com.datastructure.stack;

import com.datastructure.stack.impl.StackEmptyException;
import com.datastructure.stack.impl.StackFullException;

public class Problem_15_ThreeStacksUsingOneArray {
	
	private int maxCapacity;
	private int[] arr;
	private int top1;
	private int top2;
	private int top3;

	public Problem_15_ThreeStacksUsingOneArray(int capacity) {
		maxCapacity = capacity;
		arr = new int[maxCapacity];
		top1 = -1;
		top2 = (maxCapacity/3)-1;
		top3 = (maxCapacity/3)*2-1;
		System.out.println("Initial top1 " + top1);
		System.out.println("Initial top2 " + top2);
		System.out.println("Initial top3 " + top3);
	}
	
	// Check empty operations
	public boolean firstEmpty() {
		return top1 == -1;
	}
	public boolean secondEmpty() {
		return top2 == (maxCapacity/3)-1;
	}
	public boolean thirdEmpty() {
		return top3 == (maxCapacity/3)*2-1;
	}
	
	// Check full operations
	public boolean firstFull() {
		return top1 == (maxCapacity/3)-1;
	}
	public boolean secondFull() {
		return top2 == (maxCapacity/3)*2-1;
	}
	public boolean thirdFull() {
		return top3 == maxCapacity-1;
	}
	
	// Push operations
	public void pushTo1st(int e) throws StackFullException {
		if(firstFull()) {
			throw new StackFullException();
		}
		arr[++top1] = e;
	}
	public void pushTo2nd(int e) throws StackFullException {
		if(secondFull()) {
			throw new StackFullException();
		}
		arr[++top2] = e;
	}
	public void pushTo3rd(int e) throws StackFullException {
		if(thirdFull()) {
			throw new StackFullException();
		}
		arr[++top3] = e;
	}

	// Pop operations
	public int popFromFirst() throws StackEmptyException {
		if(firstEmpty()) {
			throw new StackEmptyException();
		}
		return arr[top1--];
	}
	public int popFromSecond() throws StackEmptyException {
		if(secondEmpty()) {
			throw new StackEmptyException();
		}
		return arr[top2--];
	}
	public int popFromThird() throws StackEmptyException {
		if(thirdEmpty()) {
			throw new StackEmptyException();
		}
		return arr[top3--];
	}
}