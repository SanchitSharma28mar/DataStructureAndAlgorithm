package com.datastructure.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Find_AllAncestors_OfANode {

	private static boolean allAncestorsOfANode(BinaryTreeNode root, int targetElement){
		List<BinaryTreeNode> list = new ArrayList<>();
		boolean found = allAncestorsOfANodeUtil(root, targetElement, list);
		if (found) {
			System.out.println(list);
		}
		return found;
	}

	private static boolean allAncestorsOfANodeUtil(BinaryTreeNode root, int targetElement, List<BinaryTreeNode> list){
		if(root == null){
			return false;
		}
		if(root.getData() == targetElement){
			return true;
		}
		boolean foundInLeft = allAncestorsOfANodeUtil(root.getLeft(), targetElement, list);
		boolean foundInRight = allAncestorsOfANodeUtil(root.getRight(), targetElement, list);
		if(foundInLeft || foundInRight){
			list.add(root);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		allAncestorsOfANode(root, 11);
	}
}
