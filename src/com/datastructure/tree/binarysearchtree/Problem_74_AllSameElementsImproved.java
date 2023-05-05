package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_74_AllSameElementsImproved {
	// Strategy: Both trees are traversed in-orderly at the same time.
	public static boolean allSame(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		if(root1 == root2){
			return true;
		}
		return allSame(root1.getLeft(), root2.getLeft()) || allSame(root1.getRight(), root2.getRight());
	}
}
