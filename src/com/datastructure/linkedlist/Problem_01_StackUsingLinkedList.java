package com.datastructure.linkedlist;

import  com.datastructure.linkedlist.impl.MySinglyNode;

/*
 * Both addition and deletion happen at the start of the list
 */
public class Problem_01_StackUsingLinkedList {
	/* top is considered as start node */
	private MySinglyNode top;
	private int length;
	
	/* Addition takes place at start of the list. */
	public void push(int d){
		MySinglyNode newNode = new MySinglyNode(d);
		if(top == null){
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
		length++;
	}
	
	public int peek(){
		return (Integer)top.getData();
	}
	
	/* Removal takes place at start of the list. */
	public int pop() throws Exception{
		if(length == 0){
			System.out.println("Can't pop as there are no elements");
			throw new Exception();
		}
		MySinglyNode temp = top;
		int value = (Integer)temp.getData();
		top = top.getNext();
		temp = null;
		return value;
	}
}
