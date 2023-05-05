package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_85_RemoveOutsideRange {
	public static void removeOutsideRange(BinaryTreeNode root, int min, int max){
		root = removeOutsideRangeUtil(root, min, max);
	}

	private static BinaryTreeNode removeOutsideRangeUtil(BinaryTreeNode current, int min, int max) {
		if(current == null){
			return null;
		}
		current.setLeft(removeOutsideRangeUtil(current.getLeft(), min, max));
		current.setRight(removeOutsideRangeUtil(current.getRight(), min, max));
		if(current.getData() < min){
			return current.getRight(); 
		}
		if(current.getData() > max){
			return current.getLeft();
		}
		return current;
	}
}