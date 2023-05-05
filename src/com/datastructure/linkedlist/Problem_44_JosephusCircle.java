package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_44_JosephusCircle {
	
	/**
	 * Idea:
	 *  Move through the Circular list till m-1
	 *  and point the current to m's next
	 *  Repeat till one node is left
	 * 
	 */
	public static MySinglyNode josephusCircle(MySinglyNode head, int m) {
		MySinglyNode temp = head;
		
		while(temp != null && temp.getNext() != null) {
			for(int i=1; i<m; i++) {
				temp = temp.getNext();
			}
			MySinglyNode next = temp.getNext();
			temp.setNext(next.getNext());
			next.setNext(null);
		}
		return temp;
	}
	
	public static void main(String[] args) {
		MySinglyNode node1 = new MySinglyNode("A");
		MySinglyNode node2 = new MySinglyNode("B");
		MySinglyNode node3 = new MySinglyNode("C");
		MySinglyNode node4 = new MySinglyNode("D");
		MySinglyNode node5 = new MySinglyNode("E");
		MySinglyNode node6 = new MySinglyNode("F");
		MySinglyNode node7 = new MySinglyNode("G");
		node7.setNext(node1);
		
		MySinglyLinkedList circluarList = new MySinglyLinkedList();
		circluarList.addAtLast(node1);
		circluarList.addAtLast(node2);
		circluarList.addAtLast(node3);
		circluarList.addAtLast(node4);
		circluarList.addAtLast(node5);
		circluarList.addAtLast(node6);
		circluarList.addAtLast(node7);
		
		MySinglyNode remainder = josephusCircle(circluarList.getHead(), 3);
		System.out.println(remainder.getData());	
	}
}