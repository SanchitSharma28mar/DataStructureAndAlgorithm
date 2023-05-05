package com.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class Find_NumberOf_HalfNodes {
	public static int numberOfHalfNodes(BinaryTreeNode node){
		if(node == null){
			return 0;
		}
		int numberOfHalfNodes = 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(node);
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.remove();
			if((temp.getLeft() == null && temp.getRight() != null)
					|| (temp.getLeft() != null && temp.getRight() == null)){
				numberOfHalfNodes++;
			}
			if(temp.getLeft() != null){
				q.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				q.add(temp.getRight());
			}
		}
		return numberOfHalfNodes;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		System.out.println(numberOfHalfNodes(root));
	}
}
