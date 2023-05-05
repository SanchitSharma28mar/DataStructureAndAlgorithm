package com.datastructure.stack.impl;

public class FixedSizeArrayStack{
	private int top;
	private int size;
	private int maxSize;
	private int[] stack;
	
	public FixedSizeArrayStack(int maxSize){
		top = -1;
		size = 0;
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	public int getSize(){
		return size;
	}
	
	public int peek(){
		return stack[top];
	}
	
	public boolean isStackEmpty(){
		return size == 0 && top == -1;
	}
	
	public boolean isStackFull(){
		return size == maxSize;
	}
	
	public void push(int e) throws StackFullException{
		if(isStackFull()){
			throw new StackFullException();
		}
		stack[++top] = e;
		size++;
	}
	
	public int pop() throws StackEmptyException{
		if(isStackEmpty()){
			throw new StackEmptyException();
		}
		int e = stack[top--];
		size--;
		return e;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i : stack) {
			s = s+" "+i;
		}
		return s;
	}
	
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		FixedSizeArrayStack myStack = new FixedSizeArrayStack(10);
		myStack.push(0);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		for (int i = 0; i < myStack.getSize(); i++) {
			System.out.print(myStack.stack[i] + " ");
		}
		System.out.println();
		System.out.println("Popped element = " + myStack.pop());
		System.out.println("Peeked element = " + myStack.peek());
		
		for (int i = 0; i < myStack.getSize(); i++) {
			System.out.print(myStack.stack[i] + " ");
		}
	}
}