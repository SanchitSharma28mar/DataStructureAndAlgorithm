package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

import java.util.*;

/**
 * LeetCode: 103 (M)
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class ZigZagLevelOrderTraversal {

	private static List<List<Integer>> zigZagTraversal(BinaryTreeNode root){
		List<List<Integer>> zigzag = new ArrayList<>();
		if(root == null){
			return zigzag;
		}

		boolean shiftDirection = false;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int currentSizeOfQueue = queue.size();
			List<Integer> levelList = new ArrayList<>();
			for(int i = 0; i < currentSizeOfQueue; i++) {
				BinaryTreeNode popped = queue.remove();
				levelList.add(popped.getData());
				if (popped.getLeft() != null)
					queue.add(popped.getLeft());
				if(popped.getRight() != null)
					queue.add(popped.getRight());
			}
			if(shiftDirection){
				Collections.reverse(levelList);
			}
			zigzag.add(levelList);
			shiftDirection = !shiftDirection;
		}
		return zigzag;
	}


	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println("Original Level Order");
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
		System.out.println("ZigZag Level Order");
		List<List<Integer>> zigZagTraversal = zigZagTraversal(root);
		zigZagTraversal.forEach(l -> {
			l.forEach(e -> {
				System.out.print(e + " ");
			});
		});
	}
}
