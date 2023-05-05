package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_06_NthNodeFromEnd_Recursion {
	// Space = O(n)(for recursive stack) : Time = O(n) 
	int counter;
	public MySinglyNode nthNodeFromEnd(MySinglyNode head, int nTh){
		if(head != null){
			nthNodeFromEnd(head.getNext(), nTh);
			counter++;
			if(counter == nTh){
				return head;
			}
		}
		return null;
	}
}
