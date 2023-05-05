package com.datastructure.linkedlist.impl;

public class MySinglyLinkedList{
	private MySinglyNode head;
	int size;

	public MySinglyLinkedList(){
		head = null;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public MySinglyNode getHead() {
		return head;
	}
	
	// Adding at start
	public void addAtStart(Object d){
		MySinglyNode temp = new MySinglyNode(d);
		if(head != null){
			temp.setNext(head);
			head = temp;
		} else {
			head = temp;	
		}
		size++;
	}

	// Adding at the end
	public void addAtLast(Object d){
		MySinglyNode temp = new MySinglyNode(d);
		addAtLast(temp);
	}
	
	// Adding a node at last
	public void addAtLast(MySinglyNode node) {
		MySinglyNode current = head;

		if(head == null){
			head = node;
			size++;
			return;
		}

		while(current != null && current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(node);
		size++;
	}

	// Adding at the index
	public void addAtIndex(Object d, int index){
		MySinglyNode temp = new MySinglyNode(d);
		MySinglyNode current = head;

		for(int i = 0 ; i < index ; i++){
			if(current.getNext() != null){
				current = current.getNext();
			}
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}

	// Removing at Start
	public boolean removeAtStart(){
		if(head == null){
			return false;	
		} else if(head.getNext() == null){
			head = null;
			return true;
		} else {
			head = head.getNext();
			size--;
			return true;
		}
	}

	// Removing at Last
	public boolean removeAtLast(){
		MySinglyNode current = head;
		while(current.getNext().getNext() != null){
			current = current.getNext();
		}
		current.setNext(null);
		size--;
		return true;
	}

	// Removing at index position
	public boolean remove(int index){
		MySinglyNode current = head;

		if(index < 0){
			return false;
		} else if(index > getSize()){
			return false;
		} 

		for(int i = 0; i < index ; i++){
			if(current != null && current.getNext() != null){
				current = current.getNext();
			}
		}

		current.setNext(current.getNext().getNext());
		size--;
		return true;
	}

	public Object getObject(int index){
		if(index < 0){
			return null;
		}
		MySinglyNode current = head;
		for(int i = 0 ; i < index ; i++){
			if(current != null && current.getNext() != null){
				current = current.getNext();
			}
		}
		return current.getData();
	}

	public int length(){
		int len = 0;
		MySinglyNode current = head;
		while(current !=null ){
			len++;
			current = current.getNext();
		}
		return len;
	}

	@Override
	public String toString() {
		return "MySinglyLinkedList [head=" + head + "]";
	}
	
}

