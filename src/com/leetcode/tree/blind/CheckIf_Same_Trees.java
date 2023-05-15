package com.leetcode.tree.blind;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 100 (E)
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class CheckIf_Same_Trees {

	private static boolean areIdentical_Recursive(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		if(root1.getData() != root2.getData()){
			return false;
		}
		boolean leftSubtreeIdentical = areIdentical_Recursive(root1.getLeft(), root2.getLeft());
		boolean rightSubtreeIdentical = areIdentical_Recursive(root1.getRight(), root2.getRight());
		return leftSubtreeIdentical && rightSubtreeIdentical;
	}

	public static void main(String[] args) {
		BinaryTreeNode root1 = BinaryTreeBuilder.tree();
		BinaryTreeNode root2 = BinaryTreeBuilder.tree();
		System.out.println("before modification = " + areIdentical_Recursive(root1, root2));
		root1.setData(11);
		System.out.println("after modification = " + areIdentical_Recursive(root1, root2));
	}
}
