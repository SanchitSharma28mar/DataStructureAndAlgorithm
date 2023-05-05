package com.leetcode.tree.binarysearchtree;

import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 108 (E)
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 */
public class Construct_Using_SortedArray {

	private static BinaryTreeNode convert(int[] arr){
		int start = 0;
		int end = arr.length - 1;
		return convertUtil(arr, start, end);
	}
	private static BinaryTreeNode convertUtil(int[] arr, int start, int end) {
		if(start > end){
			return null;
		}
		int midValue = (start + end)/2;
		BinaryTreeNode node = new BinaryTreeNode(arr[midValue]);
		// Create left subtree
		node.setLeft(convertUtil(arr, start, midValue - 1));
		// Create right subtree
		node.setRight(convertUtil(arr, midValue + 1, end));

		return node;
	}

	public static void main(String[] args) {
		int [] arr = {-10,-3,0,5,9};
		BinaryTreeNode root = convert(arr);
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
	}
}
