package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_61_RemoveDuplicatesFromUnorderedList {
	/**
	 * Idea:
	 *  List is traversed twice
	 *  Pick one outer node and check the values of rest of list in inner loop
	 *  if outer node == inner node => neglect node and set to next
	 *  Do this till the end for each outer node
	 * 
	 */
	public static MySinglyNode removeDuplicates(MySinglyNode head){
		MySinglyNode c = head;
		MySinglyNode c2 = null;
		MySinglyNode p = null;
		while(c != null){
			c2 = c.getNext();
			p = c;
			while(c2 != null){
				if(c.compareTo(c2) == 0){
					p.setNext(c2.getNext());
				}
				p = c2;
				c2 = c2.getNext();
			}
			c = c.getNext();
		}
		return head;
	}
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(1);
		linkedList.addAtLast(4);
		linkedList.addAtLast(2);
		linkedList.addAtLast(2);
		linkedList.addAtLast(3);
		linkedList.addAtLast(2);
		linkedList.addAtLast(3);
		linkedList.addAtLast(4);
		MySinglyNode newHead = removeDuplicates(linkedList.getHead());
		while(newHead != null){
			System.out.print(newHead);
			newHead = newHead.getNext();
		}
	}
}