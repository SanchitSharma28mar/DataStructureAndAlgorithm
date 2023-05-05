package com.leetcode.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

/**
 * LeetCode: 876 (E)
 */
public class MiddleNode {
	/**
	 * Idea:
	 * Two pointers fast and slow.
	 * fast travels twice the speed
	 * when it reaches the end, slow will be at middle
	 * 
	 */
	public MySinglyNode middleNode(MySinglyNode head){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}

}
