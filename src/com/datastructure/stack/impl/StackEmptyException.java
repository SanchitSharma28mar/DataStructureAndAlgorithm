package com.datastructure.stack.impl;

public class StackEmptyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackEmptyException(){
		System.out.println("Stack is empty");
	}
}
