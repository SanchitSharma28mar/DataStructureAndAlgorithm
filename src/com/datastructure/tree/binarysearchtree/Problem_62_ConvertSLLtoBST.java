package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.Model_SLLNode;
import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_62_ConvertSLLtoBST {
	// Strategy 1: Get the middle node and make it root. Do recursively.
	// O(nlogn) - As the middle node is fetched every time.
	static Model_SLLNode head = null;
	public static BinaryTreeNode convertStrategy1(){
		if(head == null){
			return null;
		}
		int len = getLength(head);
		return convertStrategy1Util(head, 0, len - 1);
	}
	private static int getLength(Model_SLLNode node){
		Model_SLLNode c = node;
		int len = 0;
		while(c != null){
			c = c.getNext();
			len++;
		}
		return len;
	}
	private static BinaryTreeNode convertStrategy1Util(Model_SLLNode head, int start, int end) {
		if(start > end){
			return null;
		}
		int mid = start + (end - start)/2;
		int i = 0;
		Model_SLLNode middleNode = head;
		while( i < mid && middleNode != null){
			middleNode = middleNode.getNext();
			i++;
		}
		BinaryTreeNode root = new BinaryTreeNode(middleNode.getData());
		root.setLeft(convertStrategy1Util(head, start, mid - 1));
		root.setRight(convertStrategy1Util(head, mid + 1, end));
		return root;
	}
}
