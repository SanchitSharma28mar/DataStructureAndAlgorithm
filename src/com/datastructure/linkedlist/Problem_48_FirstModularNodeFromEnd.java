package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_48_FirstModularNodeFromEnd {
	  
	/** 
	 * Idea:
	 * This is similar to finding nth node from end
	 * 
	 */
	public static MySinglyNode modularNodeFromEnd(MySinglyNode head, int k){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		for(int i = 0; i < k; i++) {
			fast = fast.getNext();
		}
		while(fast != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}
		return slow;
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
		MySinglyNode modularNode = modularNodeFromEnd(linkedList.getHead(), 3);
		System.out.println(modularNode);
	}
}