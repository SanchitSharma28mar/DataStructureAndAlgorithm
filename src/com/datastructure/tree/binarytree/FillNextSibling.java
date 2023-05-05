package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeNodeWithSibling;

import java.util.LinkedList;
import java.util.Queue;

public class FillNextSibling {

	public static void fillNextSibling(BinaryTreeNodeWithSibling node){
		if(node == null){
			return;
		}
		Queue<BinaryTreeNodeWithSibling> q = new LinkedList<>();
		q.add(node);
		q.add(null);
		while(!q.isEmpty()){
			BinaryTreeNodeWithSibling temp = q.remove();
			if(temp != null){
				temp.setNextSibling(q.peek());
				if(temp.getLeft() != null){
					q.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					q.add(temp.getRight());
				}
			} else {
				if(!q.isEmpty()){
					q.add(null);
				}
			}
		}
	}
}