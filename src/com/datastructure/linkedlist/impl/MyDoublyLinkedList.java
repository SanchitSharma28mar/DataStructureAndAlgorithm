package com.datastructure.linkedlist.impl;

public class MyDoublyLinkedList {

	private MyDoublyNode head;
	private MyDoublyNode tail;
	private int size;

	public int getSize(){
		return size;
	}

	public void addAtFirst(Object d){
		MyDoublyNode newNode = new MyDoublyNode(d);
		if(head == null && tail == null){
			head = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addAtLast(Object d){
		MyDoublyNode newNode = new MyDoublyNode(d);
		if(head == null && tail == null){
			addAtFirst(newNode);
			return;
		}
		tail.setNext(newNode);
		newNode.setPrev(tail);
		tail = newNode;
		size++;
	}

	public void addAtPosition(Object d, int pos){
		MyDoublyNode newNode = new MyDoublyNode(d);
		if(head == null && tail == null){
			addAtFirst(newNode);
			return;
		}

		if(pos > size){
			addAtLast(newNode);
			return;
		}

		MyDoublyNode current = head;
		for (int i = 0; i < pos; i++) {
			current = current.getNext();
		}
		MyDoublyNode temp = current.getNext();

		current.setNext(newNode);
		newNode.setPrev(current);
		newNode.setNext(temp);
		temp.setPrev(newNode);
		size++;
	}

	public Object removeFromStart(){
		if(head == null && tail == null){
			return null;
		}
		Object ret = head.getData();
		if(head == tail){
			head = null;
			tail = null;
			size--;
			return ret;
		}
		head = head.getNext();
		head.setPrev(null);
		size--;
		return ret;
	}

	public Object removeFromEnd(){
		if(head == null && tail == null){
			return null;
		}
		
		if(head == tail){
			return removeFromStart();
		}
		Object ret = tail.getData();
		tail = tail.getPrev();
		tail.setNext(null);
		size--;
		return ret;
	}
	
	public Object removeFromPosition(int pos){
		if(head == null && tail == null){
			return null;
		}
		
		if(head == tail){
			return removeFromStart();
		}
		
		if(pos > size){
			return removeFromEnd();
		}
		MyDoublyNode c = head;
		for (int i = 0; i < pos; i++) {
			c = c.getNext();
		}
		MyDoublyNode t = c.getNext().getNext();
		Object ret = c.getNext().getData();
		c.setNext(t);
		t.setPrev(c);
		size--;
		return ret;
	}
}