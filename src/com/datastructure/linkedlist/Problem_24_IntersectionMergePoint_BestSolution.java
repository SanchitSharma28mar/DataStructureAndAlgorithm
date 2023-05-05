package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_24_IntersectionMergePoint_BestSolution {
	/**
	 * Idea:
	 *  Find lengths of both LL
	 * 	diff = l1-l2
	 *  run bigger by diff
	 *  Move both by one node at a time
	 *  When they are met => Merge point
	 * 
	 */
	public MySinglyNode intersectionMergePoint(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode c1 = head1;
		MySinglyNode c2 = head2;
		int len1 = 0;
		int len2 = 0;
		// Finding length of first LL
		while(c1 != null && c1.getNext() != null){
			c1 = c1.getNext();
			len1++;
		}
		// Finding length of second LL
		while(c2 != null && c2.getNext() != null){
			c2 = c2.getNext();
			len2++;
		}
		if((Integer)c1.getData() != (Integer)c2.getData()){
			return null;
		}
		int diff = len1 - len2;
		c1 = head1;
		c2 = head2;
		if(diff < 0){
			for (int i = 0; i < diff; i++) {
				c2 = c2.getNext();
			}
		} else if(diff > 0){
			for (int i = 0; i < diff; i++) {
				c1 = c1.getNext();
			}
		}
		while(c1 != null && c2 != null){
			if((Integer)c1.getData() == (Integer)c2.getData()){
				return c1;
			}
			c1 = c1.getNext();
			c2 = c2.getNext();
		}
		return null;
	}
}
