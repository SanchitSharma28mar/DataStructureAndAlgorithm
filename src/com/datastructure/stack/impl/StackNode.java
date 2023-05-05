package com.datastructure.stack.impl;

public class StackNode {
	private int data;
	private StackNode next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	public StackNode(int d){
		data = d;
	}
	@Override
	public String toString() {
		return "[data=" + data + "]";
	}
	
}
