package com.datastructure.queue.impl;

class DynamicSizeArrayQueue {
	int[] queue;
	int front, rear, currentSize, threshold;
	public DynamicSizeArrayQueue(int maxSize){
		this.threshold = maxSize;
		front = -1;
		rear = -1;
		currentSize = 0;
		queue = new int[this.threshold];
	}
	public int getSize(){
		return currentSize;
	}
	public boolean isEmpty(){
		return rear == -1 && front == -1;
	}
	public boolean isFull(){
		return front == 0 && rear + 1 == threshold;
	}
	public int peek(){
		return queue[front];
	}
	public int dequeue() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException();
		}
		int e = queue[rear];
		queue[rear] = 0;
		if(front == rear){
			front--;
			rear--;
		} else {
			rear--;
		}

		return e;
	}
	public void enqueue(int e) throws QueueFullException{
		if(isFull()){
			increaseSize(currentSize);
		}
		if(isEmpty()){
			front = rear = 0;
			queue[rear] = e;
		} else {
			queue[++rear] = e;
		}
		currentSize++;
	}
	private void increaseSize(int size) {
		int newSize = size * 2;
		int[] newQueue = new int[newSize];
		System.arraycopy(queue, 0, newQueue, 0, newSize);
		queue = newQueue;
	}
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < queue.length; i++) {
			System.out.print(queue[i] + " " );
		}
		return s;
	}
	
	public static void main(String[] args) throws QueueFullException {
		DynamicSizeArrayQueue queue = new DynamicSizeArrayQueue(2);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		System.out.println(queue);
	}
}