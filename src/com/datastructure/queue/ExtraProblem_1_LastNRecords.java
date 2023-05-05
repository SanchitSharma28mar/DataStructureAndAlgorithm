package com.datastructure.queue;

public class ExtraProblem_1_LastNRecords {
	public static void main(String[] args) throws Exception {
		MyQueue queLast10 = new MyQueue(3);
		queLast10.add(1);
		queLast10.add(2);
		queLast10.add(3);
		for(int i = 0; i < queLast10.size ; i++){
			System.out.println(queLast10.array[i]);
		}
		System.out.println("Adding the 4th element in queue of size 3");
		queLast10.add(4);
		for(int i = 0; i < queLast10.size ; i++){
			System.out.println(queLast10.array[i]);
		}
	}
}

class MyQueue{
	int[] array;
	int maxSize;
	int size;
	int front;
	int rear;
	MyQueue(int max){
		maxSize = max;
		front = -1;
		rear = -1;
		array = new int[maxSize];
		size = 0;
	}
	public boolean isFull(){
		return front == 0 && rear+1 == maxSize;
	}
	public void add(int ele) throws Exception{
		if(isFull()){
			remove();
			shiftElements();
			array[rear] = ele;
			return;
		} 
		if(rear == -1){
			front = rear = 0;
			array[rear] = ele;
		} else {
			array[++rear] = ele;
		}
		size++;
	}
	private void shiftElements() {
		for (int i = 0; i < size; i++) {
			if(i+1 != size){
				array[i] = array[i+1];	
			}
		}
	}
	public void remove() throws Exception{
		int ele = array[front];
		System.out.println("removed ele = "+ele);
	}
}
