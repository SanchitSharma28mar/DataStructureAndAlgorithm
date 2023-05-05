package com.datastructure.tree.model;

import lombok.Data;

@Data
public class BinaryTreeNode {
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private int data;
	public BinaryTreeNode(int d){
		this.data = d;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode{" +
				"data=" + data +
				'}';
	}
}
