package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_29_DisplayReverse {
	/**
	 * Idea:
	 * Recursive method reaches the last node
	 * And prints the nodes in reverse
	 * 
	 */
	public void printInReverse(MySinglyNode head){
		if(head == null){
			return;
		}
		printInReverse(head.getNext());
		System.out.println((Integer)head.getData());
	}
}