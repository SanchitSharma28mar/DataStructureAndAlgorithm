package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_58_AddTwoLists {
	/**
	 * Idea:
	 * 	Add the two lists keeping carry over value while adding elements.
	 * 	Then reverse the list to get the correct answer.
	 * 
	 * 
	 */
	public static MySinglyNode add(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode result = null;
		MySinglyNode prev = null;
		MySinglyNode temp = null;
		int carry = 0;
		int sum = 0;
		while(head1 != null && head2 != null){
			sum = carry + (Integer)head1.getData() + (Integer)head2.getData();
			carry = sum>=10 ? 1:0;
			sum = sum%10;
			temp = new MySinglyNode(sum);

			if(result == null){
				result = temp;
			} else{
				prev.setNext(temp);
			}
			prev = temp;
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		if(carry > 0){
			temp.setNext(new MySinglyNode(carry));
		}
		return result;
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
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast(3);
		linkedList.addAtLast(4);
		linkedList.addAtLast(3);

		MySinglyLinkedList linkedList2 = new MySinglyLinkedList();
		linkedList2.addAtLast(5);
		linkedList2.addAtLast(6);
		linkedList2.addAtLast(4);

		MySinglyNode node = reverse(add(linkedList.getHead(), linkedList2.getHead()));
		while(node != null){
			System.out.print(node);
			node = node.getNext();
		}
	}
}
