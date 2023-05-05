package com.datastructure.tree.binarytree.impl;

import com.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
	
	//--------------------------------- pre-order----------------------//
	public static void preOrderRecursive(BinaryTreeNode node){
		if(node == null){
			return;
		}
		System.out.print(node.getData()+" ");
		preOrderRecursive(node.getLeft());
		preOrderRecursive(node.getRight());
	}
	/**
	 * Idea: Use Stack
	 * 
	 * Stack is a LIFO, since we want to visit the tree in order of node->left->right, 
	 * we push right node first and left node afterwards, 
	 * so that in the next iteration when we pop() from Stack
	 * we get left subtree first and then right subtree.
	 * 
	 */
	public static void preOrderIterativeUsingStack(BinaryTreeNode node){
		if(node == null){
			return;
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()){
			BinaryTreeNode temp = stack.pop();
			System.out.print(temp.getData()+" ");
			if(temp.getRight() != null){
				stack.push(temp.getRight());
			}
			if(temp.getLeft() != null){
				stack.push(temp.getLeft());
			}
		}
	}
	
	
	//--------------------------------- in-order----------------------//
	
	
	public static void inorderRecursive(BinaryTreeNode node){
		if(node == null){
			return;
		}
		inorderRecursive(node.getLeft());
		System.out.print(node.getData() + " ");
		inorderRecursive(node.getRight());
	}
	/**
	 * Idea: Stack is used and all the left children are pushed first
	 * 
	 * current is made to point to root.
	 * current is pushed to stack and also the subsequent left child of every current.
	 * At the end current points to left of leaf node which is null
	 * At this point, element is popped and printed, and current is made right child of node popped.
	 * And above steps are repeated.
	 * 
	 * the node popped is the left node at a particular level
	 * 
	 */
	public static void inorderIterativeUsingStack(BinaryTreeNode node){
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode current = node;
		while(!stack.isEmpty() || current != null){
			if(current != null){
				stack.push(current);
				current = current.getLeft();
			} else {
				BinaryTreeNode temp = stack.pop();
				System.out.print(temp.getData() + " ");
				current = temp.getRight();
			}
		}
	}
	
	
	//--------------------------------- post-order----------------------//

	
	public static void postOrderRecursive(BinaryTreeNode node){
		if(node == null){
			return;
		}
		postOrderRecursive(node.getLeft());
		postOrderRecursive(node.getRight());
		System.out.print(node.getData() + " ");
	}
	/**
	 * NOTE:Bug
	 * Solution 1: 
	 * Idea: 2 stacks are needed
	 * 
	 * Push root to first stack.
	 * Loop while first stack is not empty
	 * 		Pop a node from first stack and push it to second stack
	 * 		Push left and right children of the popped node to first stack
	 * Print contents of second stack
	 */
	public static void postOrderIterativeUsingTwoStack(BinaryTreeNode node){
		Stack<BinaryTreeNode> stack1 = new Stack<>();
		Stack<BinaryTreeNode> stack2 = new Stack<>();
		stack1.push(node);
		while(!stack1.isEmpty()){
			BinaryTreeNode temp = stack1.pop();
			stack2.push(temp);
			if(temp.getLeft() != null){
				stack1.push(temp.getLeft());
			}
			if(temp.getRight() != null){
				stack1.push(temp.getRight());
			}
		}
		System.out.print(stack2);
	}
	
	// Alternate Solution
	public static void postOrderIterativeUsingOneStack(BinaryTreeNode node){
		ArrayList<Integer> list = new ArrayList<>();
		if(node == null){
			return;
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(node);
		BinaryTreeNode previous = null;
		while(!stack.isEmpty()){
			BinaryTreeNode current = stack.peek();
		  // go down the tree.
          //  check if current node is leaf, if so, process it and pop stack,
          // otherwise, keep going down
			if(previous == null || previous.getLeft() == current || previous.getRight() == current){
				// previous == null is the situation for the root node
				if(current.getLeft() != null){
					stack.push(current.getLeft());
				} else if(current.getRight() != null){
					stack.push(current.getRight());
				} else {
					list.add(current.getData());
					stack.pop();
				}
	        // go up the tree from left node    
	        // need to check if there is a right child
	        // if yes, push it to stack
	        // otherwise, process parent and pop stack
			} else if(current.getLeft() == previous){
				if(current.getRight() != null){
					stack.push(current.getRight());
				} else {
					list.add(current.getData());
					stack.pop();
				}
	        // go up the tree from right node 
	        // after coming back from right node, process parent node and pop stack. 
			} else if(current.getRight() == previous) {
				stack.pop();
				list.add(current.getData());
			}
			previous = current;
		}
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
	
	
	//--------------------------------- level-order----------------------//

	/**
	 * NOTE: Bug
	 * 
	 */
	public static void levelOrderRecursive(BinaryTreeNode node){
		if(node != null){
			levelOrderRecursiveUtil(Arrays.asList(node));
		}
	}
	private static void levelOrderRecursiveUtil(List<BinaryTreeNode> nodeList) {
		List<BinaryTreeNode> nextLevel = new ArrayList<BinaryTreeNode>();
		for (BinaryTreeNode treeNode : nodeList) {
			System.out.println(treeNode.getData() + " ");
			if(treeNode.getLeft() != null){
				nextLevel.add(treeNode.getLeft());
			}
			if(treeNode.getRight() != null){
				nextLevel.add(treeNode.getRight());
			}
		}
		levelOrderRecursiveUtil(nextLevel);
	}
	/**
	 * Idea: using a queue 
	 * Only difference w.r.t. pre-order is that it uses a Queue instead of a stack
	 * 
	 * push root node to queue
	 * Do the following when queue is not empty:
	 * 	Pop a node from queue and print it
	 *  Push left child of popped node to queue if not null
	 *  Push right child of popped node to queue if not null
	 */
	public static void levelOrderIterativeUsingQueue(BinaryTreeNode node){
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			BinaryTreeNode temp = queue.remove();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null){
				queue.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}
		}
		System.out.println();
	}
}
