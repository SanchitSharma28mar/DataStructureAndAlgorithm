package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_33_Merge2SortedLists_Iterative {
	/**
	 * Idea:
	 * Find the smallest head
	 * make it head of final list
	 * iterate both the lists
	 * pointing to the appropriate smaller node from both
	 * Shift the pointers accordingly
	 * 
	 */
	public MySinglyNode merge(MySinglyNode head1, MySinglyNode head2){
		
		if(head1 == null){
			return head2;
		} else if(head2 == null){
			return head1;
		}

		MySinglyNode mergeHead = null;
		MySinglyNode c1 = head1;
		MySinglyNode c2 = head2;
		if((Integer)head1.getData() < (Integer)head2.getData()){
			mergeHead= head1;
		} else if ((Integer)head1.getData() > (Integer)head2.getData()){
			mergeHead = head2;
		}
		MySinglyNode C = mergeHead;
		while(c1 != null && c2 != null){
			if((Integer)c1.getData() < (Integer)c2.getData()){
				C.setNext(c1);
				c1 = c1.getNext();
			} else if ((Integer)c1.getData() > (Integer)c2.getData()){
				C.setNext(c2);
				c2 = c2.getNext();
			}
			C = C.getNext();
		}
		if(c1 !=null){
			C.setNext(c1);
		}
		if(c2 !=null){
			C.setNext(c2);
		}
		return mergeHead;
	}
}
