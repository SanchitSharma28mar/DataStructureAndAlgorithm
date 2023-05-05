package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MyTreeNode;

public class Problem_35_BinaryTreeToDLL {
	/**
	 * Idea:
	 *  Recursively convert left subtree to DLL 
	 *  Recursively convert right subtree to DLL 
	 *  make in-order successor as right node of root
	 *  make in-order predecessor as left node of root
	 *  shift root to left most node and return
	 * 
	 */
	public static MyTreeNode convert(MyTreeNode root){
		if(root == null){
			return null;
		}
		root = convertUtil(root);	
		while(root.getLeft() != null){
			root = root.getLeft();
		}
		return root;
	}
	private static MyTreeNode convertUtil(MyTreeNode root) {
		if(root.getLeft() != null){
			MyTreeNode nLeft = convertUtil(root.getLeft());
			while(nLeft.getRight() !=null){
				nLeft = nLeft.getRight();
			}
			nLeft.setRight(root);
			root.setLeft(nLeft);
		}
		if(root.getRight() != null){
			MyTreeNode nRight = convertUtil(root.getRight());
			while(nRight.getLeft() != null){
				nRight = nRight.getLeft();
			}
			root.setRight(nRight);
			nRight.setLeft(root);
		}
		return root;
	}
}