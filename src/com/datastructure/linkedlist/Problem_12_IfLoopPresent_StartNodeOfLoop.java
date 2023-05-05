package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_12_IfLoopPresent_StartNodeOfLoop {
	/**
	 * Idea:
	 *  Find loop, if it has loop
	 *  then fix one pointer at meeting point
	 *  bring second to head
	 *  Move both one node at a time each
	 *  when fast == slow
	 *  startNode is found
	 * 
	 */
	public MySinglyNode startNodeOfLoop(MySinglyNode head){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		boolean ifLoopExist = false;
		while(fast!= null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(slow == fast){
				ifLoopExist = true;
				break;
			}
		}
		if(ifLoopExist){
			slow = head;
			while(slow != fast){
				fast = fast.getNext();
				slow = slow.getNext();
			}
			return slow;
		} else {
			return null;
		}
	}
}
