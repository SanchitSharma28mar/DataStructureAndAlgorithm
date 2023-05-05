package com.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class Find_DeepestNode {
	public static BinaryTreeNode deepestNode_Iterative_Queue_BFS(BinaryTreeNode node){
		BinaryTreeNode deepestNode = null;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			deepestNode = q.remove();
			if(deepestNode.getLeft() != null){
				q.add(deepestNode.getLeft());
			}
			if(deepestNode.getRight() != null){
				q.add(deepestNode.getRight());
			}
		}
		return deepestNode;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(deepestNode_Iterative_Queue_BFS(root));
	}
}
