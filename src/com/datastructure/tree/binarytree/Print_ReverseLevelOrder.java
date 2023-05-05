package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;
import com.datastructure.tree.binarytree.impl.BinaryTreeTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Print_ReverseLevelOrder {
	/**
	 * Idea:
	 * Perform Breadth first traversal using Queue
	 * While removing from Queue, push into Stack
	 */
	public static void reverseLevelOrder(BinaryTreeNode node){
		if(node == null){
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		queue.add(node);
		while(!queue.isEmpty()){
			BinaryTreeNode temp = queue.remove();
			stack.push(temp);
			if(temp.getLeft() != null){
				queue.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().getData() + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println("Original");
		BinaryTreeTraversal.levelOrderIterativeUsingQueue(root);
		System.out.println("Reversing");
		reverseLevelOrder(root);
	}
}
