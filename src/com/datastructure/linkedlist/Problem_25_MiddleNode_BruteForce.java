package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_25_MiddleNode_BruteForce {
	/**
	 * Idea:
	 * Pick one node, increase outerCounter
	 * Find length of remaining LL
	 * Repeat till outer node reaches last node
	 * when outerCOunter == length or outerCOunter == length + 1
	 * => Middle Node
	 * 
	 */
	public static MySinglyNode middleNode(MySinglyNode head){
		MySinglyNode c = head;
		MySinglyNode t = null;
		int nodeCount = 0;
		while(c != null){
			nodeCount++;
			t = c.getNext();
			int len = 0;
			while(t != null){
				len++;
				t = t.getNext();
			}
			if(nodeCount == len+1 || nodeCount == len){
				break;
			}
			c = c.getNext();
		}
		return c;
	}
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(1);
		linkedList.addAtLast(2);
		linkedList.addAtLast(3);
		linkedList.addAtLast(4);
		linkedList.addAtLast(5);
		linkedList.addAtLast(6);
//		linkedList.addLast(new Integer(7));
//		linkedList.addLast(new Integer(8));

		System.out.println(middleNode(linkedList.getHead()));
	}
}
