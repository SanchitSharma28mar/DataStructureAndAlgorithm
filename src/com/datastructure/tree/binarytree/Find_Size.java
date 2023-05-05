package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Find_Size {
	private static int sizeUsingRecursion(BinaryTreeNode root) {
		if(root == null) return 0;
		int leftSubtreeSize = sizeUsingRecursion(root.getLeft());
		int rightSubtreeSize = sizeUsingRecursion(root.getRight());
		return leftSubtreeSize + rightSubtreeSize + 1;
	}

	private static int sizeUsingIterative_Stack_DFS(BinaryTreeNode root) {
		if(root == null) return 0;
		int size = 0;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode popped = stack.pop();
			size++;
			if(popped.getLeft() != null)
				stack.push(popped.getLeft());
			if(popped.getRight() != null)
				stack.push(popped.getRight());
		}
		return size;
	}

	private static int sizeUsingIterative_Queue_BFS(BinaryTreeNode root) {
		if(root == null) return 0;
		int size = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			size++;
			if(popped.getLeft() != null)
				queue.add(popped.getLeft());
			if(popped.getRight() != null)
				queue.add(popped.getRight());
		}
		return size;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(sizeUsingRecursion(root));
		System.out.println(sizeUsingIterative_Stack_DFS(root));
		System.out.println(sizeUsingIterative_Queue_BFS(root));
	}
}
