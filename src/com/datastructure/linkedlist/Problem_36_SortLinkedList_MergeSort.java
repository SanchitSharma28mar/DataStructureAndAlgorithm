package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_36_SortLinkedList_MergeSort {
	/**
	 * Idea:
	 * MergeSort:
	 *  Recursively divide the list into two halves
	 *  Join the nodes again in sorted fashion
	 * 
	 */
	public static MySinglyNode mergeSort(MySinglyNode node){
		if(node == null || node.getNext() == null){
			return node;
		}
		MySinglyNode middle = getMiddleNode(node);
		MySinglyNode middleNext = middle.getNext();
		middle.setNext(null);

		MySinglyNode left = mergeSort(middle);
		MySinglyNode right = mergeSort(middleNext);
		
		MySinglyNode sorted = mergeSortUtil(left, right);
		return sorted;
	}
	private static MySinglyNode mergeSortUtil(MySinglyNode left, MySinglyNode right) {
		if(left == null){
			return right;
		}
		if(right == null){
			return left;
		}
		MySinglyNode temp = null;
		if((Integer)left.getData() < (Integer)right.getData()){
			temp = left;
			temp.setNext(mergeSortUtil(left.getNext(), right));
		} else if((Integer)left.getData() > (Integer)right.getData()){
			temp = right;
			temp.setNext(mergeSortUtil(left, right.getNext()));
		}
		return temp;
	}
	private static MySinglyNode getMiddleNode(MySinglyNode node) {
		MySinglyNode fast = node;
		MySinglyNode slow = node;
		while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}
}
