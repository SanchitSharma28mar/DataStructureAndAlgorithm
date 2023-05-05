package com.datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.tree.model.BinaryTreeNode;

public class Find_NumberOf_FullNodes {

	public static int numberOfFullNodes(BinaryTreeNode node){
		if(node == null){
			return 0;
		}
		int numberOfFullNodes = 0;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.remove();
			if(temp.getLeft() != null && temp.getRight() != null){
				numberOfFullNodes++;
			}
			if(temp.getLeft() != null){
				q.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				q.add(temp.getRight());
			}
		}
		return numberOfFullNodes;
	}

	public static void main(String[] args) {

	}
}
