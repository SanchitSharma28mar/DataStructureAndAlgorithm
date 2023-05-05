package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_04_NthNodeFromEnd_WithoutHashTable {

	/**
	 * Idea:
	 * 	Iterate over linked list and find the length
	 * 	Then iterate till the (m-n+1)th node
	 * 	
	 * Space = O(1) | Time = O(n) + O(n) = O(n) 
	 */
	public static MySinglyNode nthNodeFromEnd(MySinglyNode head, int nTh){
		MySinglyNode c = head;
		int totalLength = 0;
		while(c != null){
			totalLength++;
			c = c.getNext();
		}
		if(totalLength < nTh){
			return null;
		}
		c = head;
		for (int i = 0; i < totalLength-nTh; i++) {
			c = c.getNext();
		}
		return c;
	}

	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(Integer.valueOf(1));
		linkedList.addAtLast(Integer.valueOf(2));
		linkedList.addAtLast(Integer.valueOf(3));
		linkedList.addAtLast(Integer.valueOf(4));
		linkedList.addAtLast(Integer.valueOf(5));
		linkedList.addAtLast(Integer.valueOf(6));
		linkedList.addAtLast(Integer.valueOf(7));
		linkedList.addAtLast(Integer.valueOf(8));

		System.out.println(nthNodeFromEnd(linkedList.getHead(), 3));
	}
}
