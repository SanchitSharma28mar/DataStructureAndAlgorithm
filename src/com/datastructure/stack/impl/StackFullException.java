package com.datastructure.stack.impl;

public class StackFullException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackFullException(){
		System.out.println("Stack is full");
	}
}
