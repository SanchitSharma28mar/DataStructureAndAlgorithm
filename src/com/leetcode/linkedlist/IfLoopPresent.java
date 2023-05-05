package com.leetcode.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

/**
 * LeetCode: 141 (E)
 */
public class IfLoopPresent {

	public boolean ifLoop(MySinglyNode head){
		MySinglyNode fastNode = head;
		MySinglyNode slowNode = head;
		boolean flag = false;
		while(fastNode != null && fastNode.getNext() != null){
			fastNode = fastNode.getNext().getNext();
			slowNode = slowNode.getNext();
			if(fastNode == slowNode){
				flag = true;
				break;
			}
		}
		return flag;
	}
}
