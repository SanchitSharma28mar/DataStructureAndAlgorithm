package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 236 (M)
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class LowestCommonAncestor_BT {

	private static BinaryTreeNode lca(BinaryTreeNode root, int node1, int node2){
		if(root == null) {
			// Call has gone to the bottom and didn't find the answer
			return null;
		}

		if(root.getData() == node1 || root.getData() == node2){
			// Found at least one node
			return root;
		}
		// Check in left subtree
		BinaryTreeNode nodeInLeftSubTree = lca(root.getLeft(), node1, node2);
		// Check in right subtree
		BinaryTreeNode nodeInRightSubTree = lca(root.getRight(), node1, node2);

		if(nodeInLeftSubTree != null && nodeInRightSubTree != null){
			return root;
		} else {
			return nodeInLeftSubTree != null ? nodeInLeftSubTree : nodeInRightSubTree;
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(lca(root, 4, 6));
	}
}