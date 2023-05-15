package com.leetcode.tree.blind;

import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 105 (M)
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class Construct_Using_InorderAndPreorder {

	private static Map<Integer, Integer> inorderIndexPositions = new HashMap<>();

	private static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length < 1 || inorder.length < 1){
			return null;
		}
		for(int i = 0; i < inorder.length; i++)
			inorderIndexPositions.put(inorder[i], i);

		int preorderIndex = 0;
		int inorderLow = 0;
		int inorderHigh = inorder.length - 1;
		return buildTreeUtility(preorder, preorderIndex, inorderLow, inorderHigh);
	}

	private static BinaryTreeNode buildTreeUtility(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {
		if(preorderIndex > preorder.length - 1 || inorderLow > inorderHigh){
			return null;
		}

		int preorderCurrentValue = preorder[preorderIndex];
		BinaryTreeNode node = new BinaryTreeNode(preorderCurrentValue);
		int inorderIndexValue = inorderIndexPositions.get(preorderCurrentValue);

		node.setLeft(buildTreeUtility(preorder, preorderIndex + 1,
				inorderLow, inorderIndexValue - 1));
		node.setRight(buildTreeUtility(preorder, preorderIndex + 1 + (inorderIndexValue - inorderLow) ,
				inorderIndexValue + 1, inorderHigh));

		return node;
	}

	public static void main(String[] args) {
		int[] preorder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
		int[] inorder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
		BinaryTreeNode binaryTreeNode = buildTree(preorder, inorder);
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(binaryTreeNode);
	}
}