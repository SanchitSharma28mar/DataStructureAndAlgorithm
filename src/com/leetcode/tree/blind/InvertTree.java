package com.leetcode.tree.blind;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

import java.util.Stack;

/**
 * LeetCode: 226 (E)
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertTree {

	private static void invertTree_Recursive(BinaryTreeNode root) {
		if(root == null){
			return;
		}

		BinaryTreeNode right = root.getRight();
		root.setRight(root.getLeft());
		root.setLeft(right);
		invertTree_Recursive(root.getLeft());
		invertTree_Recursive(root.getRight());
	}

	private static void invertTree_Iteratively(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode popped = stack.pop();
			BinaryTreeNode right = popped.getRight();
			popped.setRight(popped.getLeft());
			popped.setLeft(right);
			if(popped.getLeft() != null)
				stack.push(popped.getLeft());
			if(popped.getRight() != null)
				stack.push(popped.getRight());
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println("Original");
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);

		System.out.println("Mirrored/Inverted recursively");
		invertTree_Recursive(root);
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);

		System.out.println("Mirrored/Inverted again iteratively");
		invertTree_Iteratively(root);
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
	}
}
