package com.datastructure.queue.impl;

public class QueueNode {
	
	private QueueNode next;
	private int data;
	
	public QueueNode(int d){
		this.data = d;
	}
	public QueueNode getNext() {
		return next;
	}
	public void setNext(QueueNode next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}