package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_32_Merge2SortedLists_Recursive {
	
	public MySinglyNode merge(MySinglyNode head1, MySinglyNode head2){
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		MySinglyNode head = new MySinglyNode(0);
		if((Integer)head1.getData() <= (Integer)head2.getData()){
			head.setNext(merge(head1.getNext(), head2));
		} else{
			head.setNext(merge(head2.getNext(), head1));
		}
		return head.getNext();
	}
}