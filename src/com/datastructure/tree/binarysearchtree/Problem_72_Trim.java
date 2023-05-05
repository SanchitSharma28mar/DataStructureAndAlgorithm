package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

public class Problem_72_Trim {
	public static BinaryTreeNode trim(BinaryTreeNode root, int min, int max){
		if(root == null){
			return null;
		}
		if(root.getData() < min){
			return trim(root.getRight(), min, max);
		}
		if(root.getData() > max){
			return trim(root.getLeft(), min, max);
		}
		root.setLeft(trim(root.getLeft(), min, max));
		root.setRight(trim(root.getRight(), min, max));
		return root;
	}
}