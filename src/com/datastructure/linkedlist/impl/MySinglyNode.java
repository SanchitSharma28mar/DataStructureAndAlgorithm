package com.datastructure.linkedlist.impl;

public class MySinglyNode  implements Comparable<MySinglyNode>{

	private MySinglyNode next;
	private Object data;

	public MySinglyNode getNext() {
		return next;
	}
	public void setNext(MySinglyNode next) {
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public MySinglyNode(MySinglyNode next, Object data) {
		super();
		this.next = next;
		this.data = data;
	}

	public MySinglyNode(Object data) {
		super();
		this.next = null;
		this.data = data;
	}
	@Override
	public int compareTo(MySinglyNode o) {
		int ret = 0;
		if((Integer)this.getData() > (Integer)o.getData()){
			ret = 1;
		} else if((Integer)this.getData() < (Integer)o.getData()){
			ret = -1;
		}
		return ret;
	}
	@Override
	public String toString() {
		return "[data=" + data + "]";
	}

}
