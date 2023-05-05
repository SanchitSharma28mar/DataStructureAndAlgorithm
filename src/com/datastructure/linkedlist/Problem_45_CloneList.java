package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_45_CloneList {
	
	public static MySinglyNode clone(MySinglyNode head){
		MySinglyNode c1 = head;
		MySinglyNode headCopy = new MySinglyNode(head.getData());
		MySinglyNode c2 = headCopy;
		while(c1 != null){
			c1 = c1.getNext();
			if(c1 == null){
				break;
			}
			c2.setNext(new MySinglyNode(c1.getData()));
			c2 = c2.getNext();
		}
		return headCopy;
	}
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(1);
		linkedList.addAtLast(2);
		linkedList.addAtLast(3);
		linkedList.addAtLast(4);
		linkedList.addAtLast(5);
		linkedList.addAtLast(6);
		linkedList.addAtLast(7);
		linkedList.addAtLast(8);

		MySinglyNode node = clone(linkedList.getHead());
		while(node != null){
			System.out.print(node);
			node = node.getNext();
		}
	}
}
