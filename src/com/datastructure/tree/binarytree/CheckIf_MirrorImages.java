package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

public class CheckIf_MirrorImages {

	public static boolean ifMirrorImages(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		if(root1.getData() != root2.getData()){
			return false;
		}

		return ifMirrorImages(root1.getLeft(), root2.getRight())
					&& ifMirrorImages(root1.getRight(), root2.getLeft());
	}

	public static void main(String[] args) {
		BinaryTreeNode root1 = BinaryTreeBuilder.tree();
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root1);
		System.out.println();
		BinaryTreeNode root2 = BinaryTreeBuilder.mirroredTree();
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root2);
		System.out.println();
		System.out.println(ifMirrorImages(root1, root2));
	}
}