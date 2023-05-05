package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_59_ConvertBSTtoDLL {

	// Strategy 1: Getting in-order predecessor and in-order successor.
	public static BinaryTreeNode convertStrategy1(BinaryTreeNode root){
		if(root == null){
			return null;
		}
		BinaryTreeNode head = convertStrategy1Util(root);
		while(head != null){
			head = head.getLeft();
		}
		return head;
	}
	private static BinaryTreeNode convertStrategy1Util(BinaryTreeNode node) {
		if(node.getLeft() != null){
			BinaryTreeNode leftNode = convertStrategy1Util(node.getLeft());
			while(leftNode.getRight() != null){
				leftNode = leftNode.getRight();
			}
			leftNode.setRight(node);
			node.setLeft(leftNode);
		}
		if(node.getRight() != null){
			BinaryTreeNode rightNode = convertStrategy1Util(node.getRight());
			while(rightNode.getLeft() != null){
				rightNode = rightNode.getLeft();
			}
			rightNode.setLeft(node);
			node.setRight(rightNode);
		}
		return node;
	}

	// Strategy 2: Keeping track of previous node.
	public static BinaryTreeNode convertStrategy2(BinaryTreeNode root){
		BinaryTreeNode head = null;
		BinaryTreeNode previous = null;
		if(root == null){
			return null;
		}
		convertStrategy2Util(root,head,previous);
		return head;
	}
	private static void convertStrategy2Util(BinaryTreeNode node, BinaryTreeNode head,
                                             BinaryTreeNode previous) {
		if(node == null){
			return ;
		}
		convertStrategy2Util(node.getLeft(), head, previous);
		if(previous == null){
			head = node;
		} else {
			previous.setRight(node);
			node.setLeft(previous);
		}
		previous = node;
		convertStrategy2Util(node.getRight(), head, previous);
	}
}
