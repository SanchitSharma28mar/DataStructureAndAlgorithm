package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_38_SplitCircularList {
	/**
	 * Idea: Splitting CL into two halves
	 *  two pointers: fast and slow.
	 *  fast moves with twice the speed
	 *  when fast or slow reach head => stop
	 *  make the two halves circular.
	 */
	public static void splitCircularList(MySinglyNode head){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		if(fast.getNext().getNext() == head){
			fast = fast.getNext();
		}
		MySinglyNode head2 = slow.getNext();
		slow.setNext(head);
		fast.setNext(head2);
		
	}
}
