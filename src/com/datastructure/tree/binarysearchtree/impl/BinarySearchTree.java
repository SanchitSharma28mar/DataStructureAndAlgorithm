package com.datastructure.tree.binarysearchtree.impl;

import com.datastructure.tree.model.BinaryTreeNode;

public class BinarySearchTree {

	private BinaryTreeNode root;

	public static boolean find_Recursive(BinaryTreeNode root, int data){
		if(root == null){
			return false;
		}
		if(root.getData() == data){
			return true;
		}
		if(root.getData() < data){
			find_Recursive(root.getRight(), data);
		}
		if(root.getData() > data){
			find_Recursive(root.getLeft(), data);
		}
		return false;
	}

	public static boolean find_Iterative(BinaryTreeNode root, int data){
		BinaryTreeNode current = root;
		while(current != null){
			if(current.getData() == data){
				return true;
			}
			if(current.getData() < data){
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		return false;
	}

	public static int findMinimum_Recursive(BinaryTreeNode root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		if(root.getLeft() == null){
			return root.getData();
		}
		return findMinimum_Recursive(root.getLeft());
	}

	public static int findMinimum_Iterative(BinaryTreeNode root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		BinaryTreeNode current = root;
		while(current.getLeft() != null){
			current = current.getLeft();
		}
		return current.getData();
	}

	public static int findMaximum_Recursive(BinaryTreeNode root){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		if(root.getRight() == null){
			return root.getData();
		}
		return findMaximum_Recursive(root.getRight());
	}

	public static int findMaximum_Iterative(BinaryTreeNode root){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		BinaryTreeNode current = root;
		while(current.getRight() != null){
			current = current.getRight();
		}
		return current.getData();
	}

	public static BinaryTreeNode insert_Recursive(BinaryTreeNode root, int data){
		if(root == null){
			root = new BinaryTreeNode(data);
			return root;
		}
		if(root.getData() == data){
			return null;
		}
		if(root.getData() > data){
			root.setLeft(insert_Recursive(root.getLeft(), data));
		} else {
			root.setLeft(insert_Recursive(root.getLeft(), data));
		}
		return root;
	}

	public static boolean deleteIterative(BinaryTreeNode root, int data){
		BinaryTreeNode current = root;
		BinaryTreeNode parent = root;
		boolean isLeftChild = false;
		while(current.getData() != data){
			parent = current;
			if(current.getData() > data){
				current = current.getLeft();
				isLeftChild = true;
			} else {
				current = current.getRight();
				isLeftChild = false;
			}
			if(current == null){
				return false;
			}
		}
		// reached the node to be deleted
		if(ifLeafNode(current)) {
			if(current == root){
				root = null;
			}
			if(isLeftChild){
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		} else if(noLeftChild(current)) {
			if(current == root){
				root = root.getRight();
			} else if(isLeftChild){
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		} else if(noRightChild(current)) {
			if(current == root){
				root = root.getLeft();
			} else if(isLeftChild){
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if(isInsideNode(current)) {
			BinaryTreeNode successor = getSuccessor(current);
			if(current == root){
				root = successor;
			} else if(isLeftChild){
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}
		return true;
	}

	private static boolean isInsideNode(BinaryTreeNode current) {
		return current.getLeft() != null && current.getRight() != null;
	}

	private static boolean noRightChild(BinaryTreeNode current) {
		return current.getRight() == null;
	}

	private static boolean noLeftChild(BinaryTreeNode current) {
		return current.getLeft() == null;
	}

	private static boolean ifLeafNode(BinaryTreeNode node){
		return node.getLeft() == null && node.getRight() == null;
	}

	private static BinaryTreeNode getSuccessor(BinaryTreeNode node) {
		BinaryTreeNode successor = null;
		BinaryTreeNode successorParent = null;
		BinaryTreeNode current = node.getRight();
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if(successor.getRight() != null){
			successorParent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}

		return successor;
	}

	public static void insertIterative(BinaryTreeNode root, int data){
		BinaryTreeNode node = new BinaryTreeNode(data);
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		while(current != null){
			parent = current;
			if(current.getData() > data){
				current = current.getLeft();
				if(current == null){
					parent.setLeft(node);
					return;
				}
			} else {
				current = current.getLeft();
				if(current == null){
					parent.setRight(node);
					return;
				}
			}
		}
	}

}