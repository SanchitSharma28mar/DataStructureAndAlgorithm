package com.leetcode.tree.binarytree;

import com.datastructure.tree.binarytree.impl.BinaryTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 257 (E)
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 */
public class Print_AllRootToLeafPaths {

	private static void printAllRootToLeafPaths_Recursive(BinaryTreeNode root, List<String> paths, String path){
		if(root == null){
			return;
		}
		if(root.getLeft() == null && root.getRight() == null){
			paths.add(path + root.getData());
		}
		path = path + root.getData() + "->";
		printAllRootToLeafPaths_Recursive(root.getLeft(), paths, path);
		printAllRootToLeafPaths_Recursive(root.getRight(), paths, path);
	}


	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeBuilder.tree();
		List<String> list = new ArrayList<>();
		String path = "";
		printAllRootToLeafPaths_Recursive(root, list, path);
		list.forEach(System.out::println);
	}
}