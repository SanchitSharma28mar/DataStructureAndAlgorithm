package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_76_BuildHB0 {
	private static int data = 0;
	public static BinaryTreeNode buildHB0(int a, int b){
		BinaryTreeNode newNode;
		int mid = a + (b-1)/2;
		newNode = new BinaryTreeNode(data++);
		newNode.setLeft(buildHB0(a, mid - 1));
		newNode.setRight(buildHB0(mid + 1, b));
		return newNode;
	}
}