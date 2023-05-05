package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class Find_Width {

	private static int width = 0;

	private static int width(BinaryTreeNode root){
		width_Recursive(root);
		return width;
	}

	private static int width_Recursive(BinaryTreeNode root) {
		if(root == null){
			return -1;
		}
		int maxPathLeft = 1 + width_Recursive(root.getLeft());
		int maxPathRight = 1 + width_Recursive(root.getRight());
		width = Math.max(width, (maxPathRight + maxPathLeft));
		return Math.max(maxPathLeft, maxPathRight) ;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(width(root));
	}
}