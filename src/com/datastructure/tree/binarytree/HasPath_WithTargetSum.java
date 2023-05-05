package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class HasPath_WithTargetSum {

	private static boolean hasSumPath_Recursive(BinaryTreeNode root, int targetSum){
		if(root == null){
			return false;
		}
		if(targetSum - root.getData() == 0){
			return true;
		}
		targetSum -= root.getData();
		boolean hasPathInLeft = hasSumPath_Recursive(root.getLeft(), targetSum);
		boolean hasPathInRight = hasSumPath_Recursive(root.getRight(), targetSum);
		return hasPathInLeft || hasPathInRight;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(hasSumPath_Recursive(root, 10));
		System.out.println(hasSumPath_Recursive(root, 5));
	}
}
