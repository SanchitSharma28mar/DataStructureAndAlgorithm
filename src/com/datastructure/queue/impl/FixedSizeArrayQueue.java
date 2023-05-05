package com.datastructure.queue.impl;

public class FixedSizeArrayQueue {
	private int[] queue;
	public int front, rear, size, capacity;
	
	public FixedSizeArrayQueue(int capacity) {
		queue = new int[capacity];
		this.capacity = capacity;
		front = rear = -1;
	}
	
	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	public boolean isFull() {
		return front == 0 && rear+1 == capacity;
	}
	
	public int peek() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		return queue[front];
	}
	
	public void enqueue(int d) throws QueueFullException {
		if(isFull()) {
			throw new QueueFullException();
		}
		
		if(isEmpty()) {
			front ++;
		} 
		queue[++rear] = d;
		
		size++;
	}
	
	public int dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		
		int d = queue[front];
		size--;
		while(front != rear) {
			queue[front] = queue[front+1];
			front++;
		}
		rear = size-1;
		front = 0;
		return d;
	}
	
	public void display() {
		System.out.print("Displaying ");
		for(int i = 0; i < size; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		FixedSizeArrayQueue queue = new FixedSizeArrayQueue(4);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue.front + " " + queue.rear);
		queue.display();
		System.out.println("Dequeued = "+queue.dequeue());
		System.out.println(queue.front + " " + queue.rear);
		queue.display();
		queue.enqueue(5);
		System.out.println(queue.front + " " + queue.rear);
		queue.display();
	}
}
