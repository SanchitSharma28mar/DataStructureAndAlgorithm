package com.datastructure.stack;

import com.datastructure.stack.impl.StackEmptyException;
import com.datastructure.stack.impl.StackFullException;

public class Problem_14_TwoStacksUsingOneArray {
	
	private int[] array;
	private int maxCap;
	private int top1;
	private int top2;
	
	public Problem_14_TwoStacksUsingOneArray(int capacity) {
		this.maxCap = capacity;
		array = new int[maxCap];
		top1 = -1;
		top2 = capacity;
	}
	
	public boolean isFull() {
		return top2 == top1+1;
	}
	
	public boolean isEmpty1st() {
		return top1 == -1;
	}
	
	public boolean isEmpty2nd() {
		return top2 == maxCap;
	}
	
	public void pushIn1st(int d) throws StackFullException {
		if(isFull()) {
			throw new StackFullException();
		}
		array[++top1] = d;
	}
	
	public void pushIn2nd(int d) throws StackFullException {
		if(isFull()) {
			throw new StackFullException();
		}
		array[--top2] = d;
	}
	
	public int peekFrom1st() throws StackEmptyException {
		if(isEmpty1st()) {
			throw new StackEmptyException();
		}
		return array[top1];
	}
	
	public int peekFrom2nd() throws StackEmptyException {
		if(isEmpty2nd()) {
			throw new StackEmptyException();
		}
		return array[top2];
	}
	
	public int popFrom1st() throws StackEmptyException {
		if(isEmpty1st()) {
			throw new StackEmptyException();
		}
		int d = array[top1--];
		return d;
	}
	
	public int popFrom2nd() throws StackEmptyException {
		if(isEmpty2nd()) {
			throw new StackEmptyException();
		}
		int d = array[top2++];
		return d;
	}
	
	public void display() {
		System.out.println("Displaying 1st");
		for(int i = 0; i <= top1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("Displaying 2nd");
		for(int i = maxCap-1; i >= top2; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		Problem_14_TwoStacksUsingOneArray twoStack = new Problem_14_TwoStacksUsingOneArray(4);
		twoStack.pushIn1st(22);
		twoStack.display();
		
		twoStack.pushIn2nd(44);
		twoStack.display();
		
		twoStack.pushIn1st(33);
		twoStack.display();
		
		twoStack.pushIn2nd(66);
		twoStack.display();

		twoStack.popFrom1st();
		twoStack.popFrom2nd();
		twoStack.display();
		
		twoStack.pushIn1st(77);
		twoStack.display();
		twoStack.pushIn2nd(88);
		twoStack.display();
		twoStack.display();
		twoStack.popFrom1st();
		twoStack.popFrom2nd();
		twoStack.display();
		twoStack.popFrom1st();
		twoStack.popFrom2nd();
		twoStack.display();
	}
}
