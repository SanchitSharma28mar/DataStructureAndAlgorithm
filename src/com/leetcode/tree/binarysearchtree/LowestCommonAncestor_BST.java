package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 235 (M)
 * Given a binary search tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class LowestCommonAncestor_BST {

	private static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {

		if(p.getData() > root.getData() && q.getData() > root.getData()){
			return lca(root.getRight(), p, q);
		}

		if(p.getData() < root.getData() && q.getData() < root.getData()){
			return lca(root.getLeft(), p, q);
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinarySearchTreeBuilder.tree();
		BinaryTreeNode node = lca(root, new BinaryTreeNode(25), new BinaryTreeNode(35));
		System.out.println(node);
	}
}
