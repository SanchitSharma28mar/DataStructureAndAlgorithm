package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_70_PrintWithInRange {
	// Strategy 2: Level Order traversal and check for range
	public static void printWithInRangeStrategy2(BinaryTreeNode root, int r1, int r2){
		if(root == null){
			return;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.remove();
			if(temp.getData() >= r1 && temp.getData() <= r2){
				System.out.println(temp.getData() + " ");
			}
			if(temp.getLeft() != null && temp.getData() >= r1){
				q.add(temp.getLeft());
			}
			if(temp.getRight() != null && temp.getData() <= r2){
				q.add(temp.getRight());
			}
		}
	}
}
