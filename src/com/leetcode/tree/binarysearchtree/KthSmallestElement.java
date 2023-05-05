package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 230 (M)
 */
public class KthSmallestElement {

	private static int kThSmallest_UsingList(BinaryTreeNode root, int kTh){
		List<Integer> inorderList = new ArrayList<>();
		inorderTraversal(root, inorderList);
		return inorderList.get(kTh - 1);
	}

	private static void inorderTraversal(BinaryTreeNode root, List<Integer> inorderList) {
		if(root == null){
			return;
		}
		inorderTraversal(root.getLeft(), inorderList);
		inorderList.add(root.getData());
		inorderTraversal(root.getRight(), inorderList);
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinarySearchTreeBuilder.tree();
		System.out.println(kThSmallest_UsingList(root, 3));

	}
}