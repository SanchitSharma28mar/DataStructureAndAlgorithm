package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_47_LastModularNodeFromBeginning {
	/** 
	 * Idea:
	 * Modular node => i%k == 0
	 * iterate list and keep on checking i%k == 0
	 * last of the nodes which satisfies i%k == 0
	 * => Modular Node is maintained when the condition is satisfied.
	 * 
	 */
	public static MySinglyNode modularNodeFromStart(MySinglyNode head, int k){
		MySinglyNode c = head;
		MySinglyNode modularNode = null;
		int i = 1;
		while(c != null){
			if(i % k == 0){
				modularNode = c;
			}
			c = c.getNext();
			i++;
		}
		return modularNode;
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
		MySinglyNode modularNode = modularNodeFromStart(linkedList.getHead(), 3);
		System.out.println(modularNode);
	}
	
}
