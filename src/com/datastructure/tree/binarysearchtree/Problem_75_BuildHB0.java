package com.datastructure.tree.binarysearchtree;


import com.datastructure.tree.model.BinaryTreeNode;

// HB(0) is nothing but a full binary tree
public class Problem_75_BuildHB0 {
	private static int data = 0;
	public static BinaryTreeNode buildHB0(int h){
		BinaryTreeNode newNode;
		if(h == 0){
			return null;
		}
		newNode = new BinaryTreeNode(data++);
		newNode.setLeft(buildHB0(h - 1));
		newNode.setRight(buildHB0(h - 1));
		return newNode;
	}
}
