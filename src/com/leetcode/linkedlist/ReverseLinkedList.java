package com.leetcode.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

/**
 * LeetCode: 206 (E)
 */
public class ReverseLinkedList {
	/**
	 * Idea:
	 * Need to reverse the links for every node
	 * If we reverse the link of first node, we will lose the link to rest of nodes
	 * So first step is to get a reference variable which points to the next node
	 * Now reverse the link
	 * Repeat the above till last
	 * 
	 */
	public MySinglyNode reverse(MySinglyNode head){
		MySinglyNode c = head;
		MySinglyNode p = null;
		MySinglyNode n = null;
		while(c != null){
			n = c.getNext();
			c.setNext(p);
			p = c;
			c = n;
		}
		return p;
	}
}
