package com.datastructure.linkedlist.impl;

public class MyTreeNode {
	private int data;
	private MyTreeNode left;
	private MyTreeNode right;	
	
	public MyTreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public MyTreeNode getLeft() {
		return left;
	}
	public void setLeft(MyTreeNode left) {
		this.left = left;
	}
	public MyTreeNode getRight() {
		return right;
	}
	public void setRight(MyTreeNode right) {
		this.right = right;
	}
}