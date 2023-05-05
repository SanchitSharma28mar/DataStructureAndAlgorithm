package com.datastructure.queue.impl;

public class QueueEmptyException extends Exception{
	private static final long serialVersionUID = 1L;
	public QueueEmptyException(){
		System.out.println("Queue is empty");
	}
}