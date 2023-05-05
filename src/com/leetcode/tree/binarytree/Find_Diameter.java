package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 543 (E)
 * Given the root of a binary tree, return the length of the diameter of the tree
 */
public class Find_Diameter {
	private static int diameter = 0;

	private static int diameter(BinaryTreeNode root){
		diameter_Recursive(root);
		return diameter;
	}

	private static int diameter_Recursive(BinaryTreeNode root) {
		if(root == null){
			return -1;
		}
		int maxPathLeft = 1 + diameter_Recursive(root.getLeft());
		int maxPathRight = 1 + diameter_Recursive(root.getRight());
		diameter = Math.max(diameter, (maxPathRight + maxPathLeft));
		return Math.max(maxPathLeft, maxPathRight) ;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(diameter(root));
	}
}
