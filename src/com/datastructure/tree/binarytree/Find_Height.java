package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Height {

	public static int height_Recursion(BinaryTreeNode node){
		if(node == null){
			return 0;
		}
		int leftH = height_Recursion(node.getLeft());
		int rightH = height_Recursion(node.getRight());
		return Math.max(leftH, rightH) + 1;
	}

	public static int height_Iterative_Queue_BFS(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		int height = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			BinaryTreeNode popped = queue.remove();
			if(popped != null){
				if(popped.getLeft() != null)
					queue.add(popped.getLeft());
				if(popped.getRight() != null)
					queue.add(popped.getRight());
			} else {
				height++;
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}
		}
		return height;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(height_Recursion(root));
		System.out.println(height_Iterative_Queue_BFS(root));
	}
}
