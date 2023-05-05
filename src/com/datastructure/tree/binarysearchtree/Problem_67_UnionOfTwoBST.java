package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_67_UnionOfTwoBST {
	// Strategy 1: Convert both trees into sorted DLL and then create a tree.
	public static BinaryTreeNode union(BinaryTreeNode root1, BinaryTreeNode root2){
		BinaryTreeNode head1 = convertToDLL(root1);
		BinaryTreeNode head2 = convertToDLL(root2);
		BinaryTreeNode head = mergeDLL(head1, head2);
		BinaryTreeNode root = convertDLLtoBST(head);
		return root;
	}
	private static BinaryTreeNode convertToDLL(BinaryTreeNode node) {
		if(node == null){
			return null;
		}
		BinaryTreeNode head = convertToDLLUtil(node);
		while(head != null){
			head = head.getLeft();
		}
		return head;
	}
	private static BinaryTreeNode convertToDLLUtil(BinaryTreeNode node) {
		if(node.getLeft() != null){
			BinaryTreeNode left = convertToDLLUtil(node.getLeft());
			while(left.getRight() != null){
				left = left.getRight();
			}
			left.setRight(node);
			node.setLeft(left);
		}
		if(node.getRight() != null){
			BinaryTreeNode right = convertToDLLUtil(node.getRight());
			while(right.getLeft() != null){
				right = right.getLeft();
			}
			right.setLeft(node);
			node.setRight(right);
		}
		return node;
	}
	private static BinaryTreeNode mergeDLL(BinaryTreeNode head1, BinaryTreeNode head2) {
		BinaryTreeNode mainHead = null;
		if(head1.getData() < head2.getData()){
			mainHead = head1;
			head1 = head1.getRight();
		} else if(head1.getData() > head2.getData()){
			mainHead = head2;
			head2 = head2.getRight();
		}
		while(head1 != null && head2 != null){
			if(head1.getData() < head2.getData()){
				mainHead.setRight(head1);
				head1.setLeft(mainHead);
				head1 = head1.getRight();
			} else {
				mainHead.setRight(head2);
				head2.setLeft(mainHead);
				head2 = head2.getRight();
			}
			mainHead = mainHead.getRight();
		}
		while(head1 != null){
			mainHead.setRight(head1);
			head1.setLeft(mainHead);
			head1 = head1.getRight();
			mainHead = mainHead.getRight();
		} 
		while(head2 != null){
			mainHead.setRight(head2);
			head2.setLeft(mainHead);
			head2 = head2.getRight();
			mainHead = mainHead.getRight();
		}
		return mainHead;
	}
	private static BinaryTreeNode convertDLLtoBST(BinaryTreeNode head) {
		if(head == null){
			return null;
		}
		int len = getLength(head);
		return convertDLLtoBSTUtil(head, len);
	}
	private static int getLength(BinaryTreeNode head) {
		int len = 0;
		BinaryTreeNode c = head;
		while(c != null){
			len++;
			c = c.getRight();
		}
		return len;
	}
	private static BinaryTreeNode convertDLLtoBSTUtil(BinaryTreeNode head, int len) {
		if(len == 0){
			return null;
		}
		BinaryTreeNode left = convertDLLtoBSTUtil(head, len/2);
		BinaryTreeNode root = head;
		root.setLeft(left);
		head = head.getRight();
		BinaryTreeNode right = convertDLLtoBSTUtil(head, len - len/2 -1);
		root.setRight(right);
		return root;
	}
}