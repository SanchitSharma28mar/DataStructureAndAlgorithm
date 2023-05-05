package com.datastructure.linkedlist.impl;

public class MyDoublyNode implements Comparable<MyDoublyNode>{
	private MyDoublyNode prev;
	private MyDoublyNode next;
	private Object data;
	public MyDoublyNode(Object data){
		this.data = data;
	}
	public MyDoublyNode getPrev() {
		return prev;
	}
	public void setPrev(MyDoublyNode prev) {
		this.prev = prev;
	}
	public MyDoublyNode getNext() {
		return next;
	}
	public void setNext(MyDoublyNode next) {
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public int compareTo(MyDoublyNode o) {
		if((Integer)this.getData() > (Integer)o.getData()){
			return 1;
		} else if((Integer)this.getData() < (Integer)o.getData()){
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
}