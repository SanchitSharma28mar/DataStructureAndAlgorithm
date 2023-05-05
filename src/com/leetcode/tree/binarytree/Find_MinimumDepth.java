package com.leetcode.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * LeetCode: 104 (E)
 * Given the root of a binary tree, return its maximum depth.
 */
public class Find_MinimumDepth {

	public static int minimumDepth_Recursive(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		int depthLeft = minimumDepth_Recursive(root.getLeft());
		int depthRight = minimumDepth_Recursive(root.getRight());
		return Math.min(depthRight, depthLeft) + 1;
	}

	public static int minimumDepth_Iterative_Queue_BFS(BinaryTreeNode node){
		if(node == null){
			return 0;
		}
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(node);
		q.add(null);
		int minDepth = 1;
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.remove();
			if(temp != null){
				if(temp.getLeft() == null && temp.getRight() == null){
					return minDepth;
				}
				if(temp.getLeft() != null){
					q.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					q.add(temp.getRight());
				}
			} else {
				minDepth++;
				if(!q.isEmpty()){
					q.add(null);
				}
			}
		}
		return minDepth;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(minimumDepth_Recursive(root));
		System.out.println(minimumDepth_Iterative_Queue_BFS(root));
	}
}
