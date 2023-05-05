package com.datastructure.stack.impl;

public class DynamicSizeArrayStack{
	private int top = -1;
	private int currentSize = 0;
	private static  int DEFAULT_CAPACITY = 4;
	private int[] stack;
	
	public DynamicSizeArrayStack(){
		stack = new int[DEFAULT_CAPACITY];
	}
	
	public int getSize(){
		return currentSize;
	}
	
	public boolean isEmpty(){
		return top == -1 && currentSize == 0;
	}
	
	public int peek(){
		return stack[top];
	}
	
	public void push(int e){
		System.out.println("Push : " + e);
		if(currentSize == DEFAULT_CAPACITY ||
				currentSize == stack.length){
			increaseSize(currentSize);
		}
		stack[++top] = e;
		currentSize++;
	}
	
	public int pop() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException();
		}
		int e = stack[top--];
		currentSize--;
		
		if(currentSize < stack.length/2) {
			decreaseSize(stack.length);
		}
		
		return e;
	}
	
	private void decreaseSize(int size) {
		int newSize = size/2 > DEFAULT_CAPACITY ? size/2 : DEFAULT_CAPACITY;
		System.out.println("Decreased the size from " + size + " to " + newSize);
		int[] newStack = new int[newSize];
		System.arraycopy(stack, 0, newStack, 0, newSize);
		stack = newStack;
	}

	private void increaseSize(int size) {
		int newSize = size * 2;
		System.out.println("Increased the size from " + size + " to " + newSize);
		int[] newStack = new int[newSize];
		System.arraycopy(stack, 0, newStack, 0, size);
		stack = newStack;
	}
	
	public static void main(String[] args) throws StackEmptyException {
		DynamicSizeArrayStack myStack = new DynamicSizeArrayStack();
		System.out.println("Initial size : "+ myStack.getSize());
		System.out.println("Pushing 4 elements---");
		myStack.push(0);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println("Size after 1st storm : "+ myStack.getSize());
		System.out.println("Pushing other 4 elements---");
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		System.out.println("Size after 2nd storm : "+ myStack.getSize());
		System.out.println("Pushing last 2 elements---");
		myStack.push(8);
		myStack.push(9);
		System.out.println("Size after 3rd storm : "+ myStack.getSize());
		
		for (int i = 0; i < myStack.getSize(); i++) {
			System.out.print(myStack.stack[i] + " ");
		}
		System.out.println();
		myStack.push(10);
		for (int i = 0; i < myStack.getSize(); i++) {
			System.out.print(myStack.stack[i] + " ");
		}
		System.out.println();
		System.out.println("Final size after pushing all elements : "+ myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
		System.out.println("Popped element = " + myStack.pop() + " Size : " + myStack.getSize());
	}
}