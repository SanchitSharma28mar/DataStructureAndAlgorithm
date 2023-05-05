package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_15_IfLoopPresent_LengthOfLoop {
	/**
	 * Find loop and fix one pointer
	 * Move second by one node at a time
	 * count the nodes traversed till nodes meet again
	 * Gives the length of Loop
	 * 
	 */
	public int lengthOfLoop(MySinglyNode head){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		boolean ifLoopPresent = false;
		int length = 0;
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(slow == fast){
				ifLoopPresent = true;
				break;
			}
		}
		if(ifLoopPresent){
			while(slow != fast){
				slow = slow.getNext();
				length++;
			}
			length += 1;
		}
		return length;
	}
}
