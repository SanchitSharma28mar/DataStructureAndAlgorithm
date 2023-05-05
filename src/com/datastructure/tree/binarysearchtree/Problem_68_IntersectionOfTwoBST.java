package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;

public class Problem_68_IntersectionOfTwoBST {
	// Strategy 1: Using arraylists to save nodes from in-order traversal. And then checks arraylists for common nodes
	public static void intersection(BinaryTreeNode root1, BinaryTreeNode root2){
		ArrayList<BinaryTreeNode> list1 = getListFromInorder(root1);
		ArrayList<BinaryTreeNode> list2 = getListFromInorder(root2);
		printCommon(list1, list2);
	}
	private static ArrayList<BinaryTreeNode> getListFromInorder(BinaryTreeNode root) {
		ArrayList<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
		getListUtil(root, list);
		return list;
	}

	private static void getListUtil(BinaryTreeNode root, ArrayList<BinaryTreeNode> list) {
		if(root == null){
			return;
		}
		getListUtil(root.getLeft(), list);
		list.add(root);
		getListUtil(root.getRight(), list);
	}
	private static void printCommon(ArrayList<BinaryTreeNode> list1, ArrayList<BinaryTreeNode> list2) {
		if(list1 == null || list2 == null){
			return;
		}
		int l1 = list1.size();
		int l2 = list2.size();
		int i = 0, j = 0;
		while(i < l1 && j < l2){
			if(list1.get(i).getData() > list2.get(j).getData()){
				j++;
			} else if(list1.get(i).getData() < list2.get(j).getData()){
				i++;
			} else if(list1.get(i).getData() == list2.get(j).getData()){
				System.out.print(list1.get(i).getData() + " ");
			}
		}		
	}
}