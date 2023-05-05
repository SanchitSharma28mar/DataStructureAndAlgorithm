package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyLinkedList;
import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_40_ExchangeAdjacent {
	/**
	 * Same as that of reversing pair.
	 * 
	 */
	public static MySinglyNode exchangeAdjacent(MySinglyNode head){
		if(head == null || head.getNext() == null){
			return head;
		}
		MySinglyNode p = head;
		MySinglyNode c = head.getNext();
		head = c;
		while(true){
			MySinglyNode n = c.getNext();
			c.setNext(p);
			if(n == null || n.getNext() == null){
				p.setNext(n);
				break;
			}
			p.setNext(n.getNext());
			p = n;
			c = p.getNext();
		}
		return head;
	}
	public static void main(String[] args) {
		MySinglyLinkedList linkedList = new MySinglyLinkedList();
		linkedList.addAtLast("1");
		linkedList.addAtLast("2");
		linkedList.addAtLast("3");
		linkedList.addAtLast("4");
		for(int i = 0 ; i < linkedList.getSize() ; i++){
			System.out.print(linkedList.getObject(i)+" ");
		}
		System.out.println("========================");
		MySinglyNode newHead = exchangeAdjacent(linkedList.getHead());
		while(newHead != null){
			System.out.print(newHead.getData()+" ");
			newHead = newHead.getNext();
		}
	}
}
