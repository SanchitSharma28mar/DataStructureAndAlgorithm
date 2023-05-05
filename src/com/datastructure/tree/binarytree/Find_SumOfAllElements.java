package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Find_SumOfAllElements {

	private static int sum_Recursion(BinaryTreeNode root) {
		if(root == null){
			return 0;
		}
		int leftSubTreeSum = sum_Recursion(root.getLeft());
		int rightSubTreeSum = sum_Recursion(root.getRight());
		return leftSubTreeSum + rightSubTreeSum + root.getData();
	}

	private static int sum_Iterative_Queue_BFS(BinaryTreeNode root){
		int sum = 0;
		if(root == null){
			return 0;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			sum += popped.getData();
			if(popped.getLeft() != null)
				queue.add(popped.getLeft());
			if(popped.getRight() != null)
				queue.add(popped.getRight());
		}
		return sum;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(sum_Recursion(root));
		System.out.println(sum_Iterative_Queue_BFS(root));

	}
}
