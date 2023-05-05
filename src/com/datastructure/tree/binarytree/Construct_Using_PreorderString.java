package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;
import com.datastructure.tree.model.BinaryTreeNode;

/**
 * Given preorder traversal of this tree, construct the tree. [ILILL]
 * L - Leaf node
 * I - internal node
 * Assume that each node has either 0 or 2 children.
 */
public class Construct_Using_PreorderString {

	public static BinaryTreeNode constructTree(String preorder){
		BinaryTreeNode root = constructTreeUtil(preorder.toCharArray(), 0);
		return root;
	}

	private static BinaryTreeNode constructTreeUtil(char[] charArray, int i) {
		if(charArray.length == i){
			return null;
		}
		BinaryTreeNode node = new BinaryTreeNode(charArray[i]);

		if(charArray[i] == 'L'){
			return node;
		}

		node.setLeft(constructTreeUtil(charArray, i + 1));
		node.setRight(constructTreeUtil(charArray, i + 1));
		return node;
	}

	public static void main(String[] args) {
		String preorderString = "ILILL";
		BinaryTreeNode binaryTreeNode = constructTree(preorderString);
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(binaryTreeNode);
	}
}