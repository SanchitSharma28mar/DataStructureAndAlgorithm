package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 98 (M)
 */
public class ValidateBST {

	public static boolean ifBST(BinaryTreeNode root){
		return ifBSTUtil(root, null, null);
	}

	private static boolean ifBSTUtil(BinaryTreeNode root, Integer minValue, Integer maxValue) {
		if(root == null){
			return true;
		}

		if((minValue != null && root.getData() <= minValue) ||
				(maxValue != null && root.getData() >= maxValue)){
			return false;
		}

		// Left Subtree = maxValue shouldn't be greater than root's value
		boolean checkForLeftSubtree = ifBSTUtil(root.getLeft(), minValue, root.getData());
		// Right Subtree = minValue shouldn't be less than root's value
		boolean checkForRightSubtree = ifBSTUtil(root.getRight(), root.getData(), maxValue);
		return checkForLeftSubtree && checkForRightSubtree;
	}

	public static void main(String[] args) {
		BinaryTreeNode binaryTree = BinaryTreeBuilder.tree();
		System.out.println(ifBST(binaryTree));

		BinaryTreeNode binarySearchTree = BinarySearchTreeBuilder.tree();
		System.out.println(ifBST(binarySearchTree));
	}
}
