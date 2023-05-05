package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_39_IsListPalindrome {
	/**
	 * Idea:
	 *  Split list into two from middle
	 *  reverse the second
	 *  match the two lists
	 * 
	 */
	public static boolean isPalindrome(MySinglyNode head){
		boolean flag = true;
		// Step 1: Split linked list in the middle
		MySinglyNode middle = getMiddle(head);
		MySinglyNode middleNext = middle.getNext();
		middle.setNext(null);
		// Step 2: Reverse the second half 
		MySinglyNode head2 = reverse(middleNext);
		// Step 3: Compare
		while(head != null && head2 != null){
			if((Integer)head.getData() != (Integer)head2.getData()){
				flag = false;
				break;
			}
			head = head.getNext();
			head2 = head2.getNext();
		}
		return flag;
	}
	private static MySinglyNode getMiddle(MySinglyNode head) {
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}
	private static MySinglyNode reverse(MySinglyNode head) {
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