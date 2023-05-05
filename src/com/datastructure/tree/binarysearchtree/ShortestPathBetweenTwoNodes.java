package com.datastructure.tree.binarysearchtree;

import com.datastructure.tree.binarysearchtree.impl.BinarySearchTreeBuilder;
import com.datastructure.tree.model.BinaryTreeNode;

public class ShortestPathBetweenTwoNodes {

	public static int shortestPath(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2){

		BinaryTreeNode lowestCommonAncestor = lca(root, node1, node2);

		return shortestPathUtil(lowestCommonAncestor, node1.getData(), node2.getData());
	}

	private static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {

		// when both are on the right subtree
		if(node1.getData() > root.getData() && node2.getData() > root.getData()){
			return lca(root.getRight(), node1, node2);
		}

		// when both are on the left subtree
		if(node1.getData() < root.getData() && node2.getData() < root.getData()){
			return lca(root.getLeft(), node1, node2);
		}
		return root;
	}

	private static int shortestPathUtil(BinaryTreeNode rootNode, int data1, int data2) {
		int leftPath = 0;
		int rightPath = 0;

		// reach data1 from lca
		BinaryTreeNode current1 = rootNode;
		while(current1.getData() != data1){
			if(current1.getData() > data1){
				current1 = current1.getLeft();
			} else {
				current1 = current1.getRight();
			}
			leftPath++;
		}

		// reach data2 from lca
		BinaryTreeNode current2 = rootNode;
		while(current2.getData() != data2){
			if(current2.getData() > data2){
				current2 = current2.getLeft();
			} else {
				current2 = current2.getRight();
			}
			rightPath++;
		}
		return leftPath + rightPath;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = BinarySearchTreeBuilder.tree();
		int shortestPath = shortestPath(root, new BinaryTreeNode(25), new BinaryTreeNode(35));
		System.out.println(shortestPath);
	}
}
