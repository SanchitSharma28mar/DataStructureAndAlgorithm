package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_16_InsertInSortedList {
	/**
	 * Idea:
	 * traverse till data of node is greater than d
	 * 
	 */
	public void insert(MySinglyNode head, int d){
		MySinglyNode n = new MySinglyNode(d);
		if(head == null){
			head = n;
			return;
		}
		MySinglyNode c = head;
		while(c.getNext() != null && (Integer)c.getData() < d){
			c = c.getNext();
		}
		MySinglyNode next = c.getNext();
		c.setNext(n);
		n.setNext(next);
	}
}
