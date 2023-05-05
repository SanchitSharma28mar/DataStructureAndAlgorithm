package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_69_PrintWithInRange {
	// Strategy 1: In-order traversal and check for the range
	public static void printWithInRangeStrategy1(BinaryTreeNode root, int r1, int r2){
		if(root == null){
			return;
		}
		if(root.getData() >= r1){
			printWithInRangeStrategy1(root.getLeft(), r1, r2);
		}
		if(root.getData() >= r1 && root.getData() <= r2){
			System.out.println(root.getData() + " ");
		}
		if(root.getData() <= r2){
			printWithInRangeStrategy1(root.getRight(), r1, r2);
		}
	}
}
