package com.datastructure.tree.binarytree;

import com.datastructure.tree.model.BinaryTreeNode;

/**
 * Isomorphic tree are structurally identical.
 * They may or may not have the same data.
 */
public class IsomorphicTrees {
	public static boolean isIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if((root1.getLeft() == null && root2.getLeft() != null) ||
				(root1.getLeft() != null && root2.getLeft() == null)){
			return false;
		}
		return isIsomorphic(root1.getLeft(), root2.getLeft()) && isIsomorphic(root1.getRight(), root2.getRight());
	}
}