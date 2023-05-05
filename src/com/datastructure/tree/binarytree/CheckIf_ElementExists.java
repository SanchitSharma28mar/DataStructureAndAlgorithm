package com.datastructure.tree.binarytree;


import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckIf_ElementExists {
	private static boolean searchUsingRecursion(BinaryTreeNode root, int target){
		if(root == null) return false;
		if(root.getData() == target) return true;
		boolean leftSubtreeSearchResult = searchUsingRecursion(root.getLeft(), target);
		boolean rightSubtreeSearchResult = searchUsingRecursion(root.getRight(), target);
		return leftSubtreeSearchResult || rightSubtreeSearchResult;
	}

	private static boolean searchUsingIterative_Stack_DFS(BinaryTreeNode root, int target){
		if(root == null) return false;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode popped = stack.pop();
			if(popped.getData() == target)
				return true;
			if(popped.getLeft() != null)
				stack.push(popped.getLeft());
			if(popped.getRight() != null)
				stack.push(popped.getRight());
		}
		return false;
	}

	private static boolean searchUsingIterative_Queue_BFS(BinaryTreeNode root, int target){
		if(root == null) return false;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			if(popped.getData() == target)
				return true;
			if(popped.getLeft() != null)
				queue.add(popped.getLeft());
			if(popped.getRight() != null)
				queue.add(popped.getRight());
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		int target = 4;
		System.out.println(searchUsingRecursion(root, target));
		System.out.println(searchUsingIterative_Stack_DFS(root, target));
		System.out.println(searchUsingIterative_Queue_BFS(root, target));
	}
}
