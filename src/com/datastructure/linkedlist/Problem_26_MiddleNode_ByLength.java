package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_26_MiddleNode_ByLength {
	
	/**
	 * Idea:
	 * Traverse the list to find the length.
	 * Traverse again till length/2. That will be the middle node of the LinkedList
	 * 
	 * @param head
	 * @return
	 */
	public MySinglyNode middleNode(MySinglyNode head){
		MySinglyNode c = head;
		int len = 0;
		while(c != null){
			c = c.getNext();
			len++;
		}
		c = head;
		for (int i = 0; i < len/2; i++) {
			c = c.getNext();
		}
		return c;
	}
}
