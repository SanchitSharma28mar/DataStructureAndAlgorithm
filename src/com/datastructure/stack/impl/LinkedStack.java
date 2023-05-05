package com.datastructure.stack.impl;

public class LinkedStack{
	
	private StackNode top;
	private int size;
	
	public boolean isEmpty(){
		return size == 0 && top == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public int peek(){
		return top.getData();
	}
	
	public void push(int d){
		StackNode newNode = new StackNode(d);
		if(top == null){
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
		size++;
	}
	
	public StackNode pop() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException();
		}
		StackNode popped = top;
		StackNode temp = top;
		top = temp.getNext();
		temp = null;
		return popped;
	}
}
