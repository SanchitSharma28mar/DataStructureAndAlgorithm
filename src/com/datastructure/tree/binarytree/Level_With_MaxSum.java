package com.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class Level_With_MaxSum {
	public static int maximumSumLevel(BinaryTreeNode node){
		if(node == null){
			return 0;
		}
		int maxSum = 0;
		int currentSum = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			if (popped != null) {
				currentSum += popped.getData();
				if(popped.getLeft() != null){
					queue.add(popped.getLeft());
				}
				if(popped.getRight() != null){
					queue.add(popped.getRight());
				}
			} else {
				maxSum = Math.max(currentSum, maxSum);
				currentSum = 0;
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(maximumSumLevel(root));
	}
}
