package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.Model_DLLNode;

public class Problem_60_ConvertDLLtoBST {
	
	// Strategy 1: Finding the middle node and making it root, doing it recursively
	public static Model_DLLNode convertStrategy1(Model_DLLNode head){
		if(head == null){
			return null;
		}
		Model_DLLNode root = null;
		root = convertStrategy1Util(head, root);
		return root;
	}
	private static Model_DLLNode convertStrategy1Util(Model_DLLNode head, Model_DLLNode root) {
		return null;
	}
	
	// Strategy 2: Bottom-up approach, reducing complexity by making BST as and when the nodes of DLL are traversed
	/**
	 * Idea:
	 * Find the length
	 * And then split DLL into two
	 * with left part make left subtree
	 * with right part make right subtree 
	 *  
	 * 
	 */
	static Model_DLLNode head = null;
	public static Model_DLLNode convertStrategy2(){
		if(head == null){
			return null;
		}
		int length = getLengdthOfDLL(head);
		return convertStrategy2Util(length);
	}
	private static int getLengdthOfDLL(Model_DLLNode head) {
		int len = 0;
		Model_DLLNode current = head;
		while(current != null){
			current = current.getNext();
			len++;
		}
		return len;
	}
	private static Model_DLLNode convertStrategy2Util(int length) {
		if(length <= 0){
			return null;
		}
		Model_DLLNode left = convertStrategy2Util(length/2);
		Model_DLLNode root = head;
		root.setPrev(left);
		head = head.getNext();
		root.setNext(convertStrategy2Util(length - length/2 -1));		
		return root;
	}
}