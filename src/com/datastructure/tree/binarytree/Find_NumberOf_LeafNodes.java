package com.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class Find_NumberOf_LeafNodes {

	public static int numberOfLeaves(BinaryTreeNode node){
		if(node == null){
			return 0;
		}
		int numberOfLeafNodes = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			if(popped.getLeft() == null && popped.getRight() == null){
				numberOfLeafNodes++;
			}
			if(popped.getLeft() != null){
				queue.add(popped.getLeft());
			}
			if(popped.getRight() != null){
				queue.add(popped.getRight());
			}
		}
		return numberOfLeafNodes;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
	}
}
