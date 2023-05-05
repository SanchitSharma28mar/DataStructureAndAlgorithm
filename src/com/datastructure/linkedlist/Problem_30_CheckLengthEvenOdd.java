package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_30_CheckLengthEvenOdd {
	/**
	 * Idea:
	 * Take one pointer
	 * Move it every two nodes at a time
	 * if node == null => Even
	 * else => odd
	 * 
	 */
	public boolean isEven(MySinglyNode head){
		boolean flag = false;
		MySinglyNode fast = head;
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
		}
		if(fast == null){
			flag = true;
		}
		return flag;
	}
}
