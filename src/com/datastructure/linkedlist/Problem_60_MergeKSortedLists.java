package com.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_60_MergeKSortedLists {
	
	/**
	 * Idea:
	 * 	Take one list and merge it with other lists one by one in a sequence.
	 * 	Keep sorted order while merging.
	 * 
	 * O(k^2*n).
	 */
	public static MySinglyNode mergeKLists(List<MySinglyNode> listOfLists){
		if(listOfLists == null || listOfLists.size() == 0){
			return null;
		}
		if(listOfLists.size() == 1){
			return listOfLists.get(0);
		}
		int k = listOfLists.size();
		MySinglyNode newHead = listOfLists.get(0);
		for (int i = 1; i < k; i++) {
			newHead = mergeTwoLists(newHead, listOfLists.get(i));
		}
		return newHead;
	}
	private static MySinglyNode mergeTwoLists(MySinglyNode h1, MySinglyNode h2){
		MySinglyNode c1 = h1;
		MySinglyNode c2 = h2;
		MySinglyNode mergeNodeHead;
		if(c1.compareTo(c2) < 0){
			mergeNodeHead = c1;
			c1 = c1.getNext();
		} else {
			mergeNodeHead = c2;
			c2 = c2.getNext();
		}
		MySinglyNode p = mergeNodeHead;

		while(c1 != null && c2 != null){
			if(c1.compareTo(c2) < 0){
				p.setNext(c1);
				p = p.getNext();
				c1 = c1.getNext();
			} else {
				p.setNext(c2);
				p = p.getNext();
				c2 = c2.getNext();
			}	
		}
		if(c1 != null){
			p.setNext(c1);
		} else {
			p.setNext(c2);
		}
		return mergeNodeHead;
	}
	public static void main(String[] args) {
		MySinglyNode l1 = new MySinglyNode(1);
		MySinglyNode l2 = new MySinglyNode(2);
		MySinglyNode l3 = new MySinglyNode(3);
		MySinglyNode l4 = new MySinglyNode(4);
		MySinglyNode l5 = new MySinglyNode(5);
		MySinglyNode l6 = new MySinglyNode(6);

		l1.setNext(l6);
		l2.setNext(l4);
		l3.setNext(l5);

		MySinglyNode c1 = l1;
		System.out.print("First List : ");
		while(c1 != null){
			System.out.print(c1.getData() + " ");
			c1 = c1.getNext();
		}
		System.out.println();
		MySinglyNode c2 = l2;
		System.out.print("Second List : ");
		while(c2 != null){
			System.out.print(c2.getData() + " ");
			c2 = c2.getNext();
		}
		System.out.println();
		MySinglyNode c3 = l3;
		System.out.print("Third List : ");
		while(c3 != null){
			System.out.print(c3.getData() + " ");
			c3 = c3.getNext();
		}
		System.out.println();
		List<MySinglyNode> list = new ArrayList<MySinglyNode>();
		list.add(l2);
		list.add(l1);
		list.add(l3);
		System.out.print("Merged List : ");
		MySinglyNode C = mergeKLists(list);
		while(C != null){
			System.out.print(C.getData() + " ");
			C = C.getNext();
		}
	}
}
