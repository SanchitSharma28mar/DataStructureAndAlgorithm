package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.Model_SLLNode;
import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_63_ConvertSLLtoBSTImproved {
	// Strategy 2: Creating BST as and when the nodes of linked list are traversed. Bottom-up approach
	// O(n)
	public static BinaryTreeNode convertStrategy2(Model_SLLNode head){
		if(head == null){
			return null;
		}
		int len = getListLength(head);
		int start = 0;
		int end = len - 1;
		return convertStrategy2Util(head, start, end);
	}
	private static int getListLength(Model_SLLNode head) {
		int len = 0;
		Model_SLLNode c = head;
		while(c != null){
			c = c.getNext();
			len++;
		}
		return len;
	}
	private static BinaryTreeNode convertStrategy2Util(Model_SLLNode head, int start, int end) {
		if(start > end){
			return null;
		}
		int mid = (start + end)/2;
		BinaryTreeNode root = new BinaryTreeNode(head.getData());
		BinaryTreeNode leftNode = convertStrategy2Util(head, start, mid - 1);
		head = head.getNext();
		BinaryTreeNode rightNode = convertStrategy2Util(head, mid + 1, end);
		root.setLeft(leftNode);
		root.setRight(rightNode);
		return root;
	}
}
