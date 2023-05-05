package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_54_ReorderList {

	/**
	 * INPUT: 1 2 3 4 5 6 
	 * OUTPUT: 1 6 2 5 3 4  
	 * 
	 * Idea:
	 * 1 - Find the middle of the linked list using Floyd approach and split
	 * 2 - Reverse the second linked list
	 * 3 - Merge the two lists one element at a time alternatively
	 * 
	 * 
	 */
	public static MySinglyNode reorder(MySinglyNode head){
		MySinglyNode fast = head;
		MySinglyNode slow = head;
		// Step 1. a. Find middle of the list
		while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		// Step 1. b. Split from the middle
		MySinglyNode middle = slow;
		MySinglyNode head2 = middle.getNext();
		middle.setNext(null);
		// Step 2. Reverse the second half
		MySinglyNode reverseHead = reverse(head2);
		// Step 3. Merge the two lists one element at a time.
		MySinglyNode node = mergeTwoLists(head, reverseHead);
		return node;
	}
	public static MySinglyNode reverse(MySinglyNode head){
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
	private static MySinglyNode mergeTwoLists(MySinglyNode head, MySinglyNode head2) {
		MySinglyNode newHead = head;
		head = head.getNext();
		MySinglyNode c = newHead;
		boolean flag = false;
		while(head != null && head2 != null){
			if(flag){
				c.setNext(head);
				head = head.getNext();
				flag = false;
			} else {
				c.setNext(head2);
				head2 = head2.getNext();
				flag = true;
			}
			c = c.getNext();
		}
		if(head != null){
			c.setNext(head);
		} 
		if(head2 != null){
			c.setNext(head2);
		}
		return newHead;
	}
	public static void main(String[] args) {
		MySinglyLinkedList ll = new MySinglyLinkedList();
		ll.addAtLast(1);
		ll.addAtLast(2);
		ll.addAtLast(3);
		ll.addAtLast(4);
		ll.addAtLast(5);
		ll.addAtLast(6);
		MySinglyNode node = reorder(ll.getHead());
		while (node != null) {
			System.out.print(node);
			node = node.getNext();
		}
	}
}