package com.datastructure.linkedlist.impl;

public class MyCircularLinkedList {
	
	private MySinglyNode tail;
	private int size;
	
	public int getLength() {
		return size;
	}

	// Add at the start. i.e. before tail's next
	public void addAtStart(int data) {
		MySinglyNode newNode = new MySinglyNode(data);
		newNode.setNext(newNode);
		if (tail != null){
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		size++;
	}
	
	// Add at at the end. i.e after tail
	public void addAtEnd(int data) {
		addAtStart(data);
		tail = tail.getNext();
	}
	
	public int removeFromStart() {
		if(tail == null) {
			return Integer.MIN_VALUE;
		}
		if(getLength() == 1) {
			tail.setNext(null);
			return (Integer)tail.getData();
		}
		
		MySinglyNode node = tail.getNext();
		tail.setNext(node.getNext());
		node.setNext(null);
		int d = (Integer)node.getData();
		node = null;
		return d;
	}
	
	public int removeFromEnd() {
		if(tail == null) {
			return Integer.MIN_VALUE;
		}
		if(getLength() == 1) {
			tail.setNext(null);
			return (Integer)tail.getData();
		}
		
		MySinglyNode temp = tail.getNext();
		while(temp != null && temp!=tail) {
			temp = temp.getNext();
		}
		temp.setNext(tail.getNext());
		int d = (Integer)tail.getData();
		tail.setNext(null);
		return d;
	}
}
