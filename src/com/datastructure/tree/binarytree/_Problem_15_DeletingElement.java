package com.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class _Problem_15_DeletingElement {
	/**
	 * Idea: Level order traversal using Queue.
	 * Traverse the tree and check for the node.
	 * Replace the node with one of the leaf nodes
	 * delete the leaf node
	 * 
	 */
	public static void deletingElement(BinaryTreeNode node, int data){
		if(node == null){
			return;
		}
		BinaryTreeNode dataNode = null;
		BinaryTreeNode poppedNode = null;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			poppedNode = q.remove();
			if(poppedNode.getData() == data){
				dataNode = poppedNode;
			}
			if(poppedNode.getLeft() != null){
				q.add(poppedNode.getLeft());
			}
			if(poppedNode.getRight() != null){
				q.add(poppedNode.getRight());
			}
		}
		dataNode.setData(poppedNode.getData());
		poppedNode = null;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		Print_ReverseLevelOrder.reverseLevelOrder(root);
		deletingElement(root, 14);
		System.out.println("After deletion");
		Print_ReverseLevelOrder.reverseLevelOrder(root);
	}
}