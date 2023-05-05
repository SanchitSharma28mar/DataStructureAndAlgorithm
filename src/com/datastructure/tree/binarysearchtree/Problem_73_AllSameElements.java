package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.model.BinaryTreeNode;

import java.util.HashMap;

public class Problem_73_AllSameElements {
	public static boolean allSame(BinaryTreeNode root1, BinaryTreeNode root2){
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		getHashMapFromInorder(map, root1);
		return checkUsingInorder(map,root2);
	}
	private static HashMap<Integer, Boolean> getHashMapFromInorder(HashMap<Integer, Boolean> map, BinaryTreeNode root) {
		if(root == null){
			return null;
		}
		getHashMapFromInorder(map, root.getLeft());
		map.put(root.getData(), true);
		getHashMapFromInorder(map, root.getRight());
		return map;
	}
	private static boolean checkUsingInorder(HashMap<Integer, Boolean> map, BinaryTreeNode root) {
		if(root == null){
			return true;
		}
		checkUsingInorder(map, root.getLeft());
		if(!map.containsKey(root.getData())){
			return false;
		}
		checkUsingInorder(map, root.getRight());
		return true;
	}
}
