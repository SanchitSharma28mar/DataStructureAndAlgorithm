package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Find_MaximumElement {
	private static int maximumUsingRecursion(BinaryTreeNode root){
		if(root == null) return Integer.MIN_VALUE;
		int leftMax = maximumUsingRecursion(root.getLeft());
		int rightMax = maximumUsingRecursion(root.getRight());
		return Math.max(Math.max(leftMax, rightMax), root.getData());
	}

	private static int maximumUsingIterative_Stack_DFS(BinaryTreeNode root){
		int max = Integer.MIN_VALUE;
		if(root == null) return max;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode popped = stack.pop();
			max = Math.max(popped.getData(), max);
			if(popped.getLeft() != null)
				stack.push(popped.getLeft());
			if(popped.getRight() != null)
				stack.push(popped.getRight());
		}
		return max;
	}

	private static int maximumUsingIterative_Queue_BFS(BinaryTreeNode root){
		int max = Integer.MIN_VALUE;
		if(root == null) return max;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			max = Math.max(popped.getData(), max);
			if(popped.getLeft() != null)
				queue.add(popped.getLeft());
			if(popped.getRight() != null)
				queue.add(popped.getRight());
		}
		return max;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(maximumUsingRecursion(root));
		System.out.println(maximumUsingIterative_Stack_DFS(root));
		System.out.println(maximumUsingIterative_Queue_BFS(root));
	}
}
