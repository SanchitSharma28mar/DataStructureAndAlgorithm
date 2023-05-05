package com.datastructure.queue.impl;

public class QueueFullException  extends Exception{
	private static final long serialVersionUID = 1L;
	public QueueFullException(){
		System.out.println("Queue is full");
	}
}
