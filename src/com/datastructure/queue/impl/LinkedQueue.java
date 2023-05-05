package com.datastructure.queue.impl;

public class LinkedQueue{
	
	private QueueNode front, rear;
	private int size;
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return front == null && rear == null;
	}
	
	public int peek() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException();
		}
		return front.getData();
	}
	
	public void enqueue(int d){
		QueueNode node = new QueueNode(d);
		if(isEmpty()){
			front = node;
			rear = node;
		} else {
			rear.setNext(node);
			rear = rear.getNext();
		}
		size++;
	}
	
	public int dequeue() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException();
		}
		QueueNode node = front;
		if(front == rear){
			front = null;
			rear = null;
		} else {
			front = front.getNext();
		}
		size--;
		return node.getData();
	}
}