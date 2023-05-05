package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

import java.util.LinkedList;
import java.util.Queue;


public class Insertion {

	private static BinaryTreeNode insertion_Recursive(BinaryTreeNode root, int data){
		if(root == null){
			return new BinaryTreeNode(data);
		}
		if(root.getLeft() == null){
			root.setLeft(new BinaryTreeNode(data));
			return root;
		}
		return insertion_Recursive(root.getLeft(), data);
	}

	private static BinaryTreeNode insertIterative(BinaryTreeNode root, int data){
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		if(root == null){
			return newNode;
		}

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			if(popped.getLeft() != null) {
				queue.add(popped.getLeft());
			} else if(popped.getRight() != null) {
				queue.add(popped.getRight());
			} else {
				popped.setLeft(newNode);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
		BinaryTreeNode binaryTreeNode = insertion_Recursive(root, 20);
		System.out.println("After insertion");
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(binaryTreeNode);
		BinaryTreeNode binaryTreeNode1 = insertIterative(root, 50);
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(binaryTreeNode1);
	}
}
