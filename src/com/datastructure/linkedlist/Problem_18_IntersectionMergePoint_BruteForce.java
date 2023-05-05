package com.datastructure.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

public class Problem_18_IntersectionMergePoint_BruteForce {
	/**
	 * Idea:
	 *  Pick one node of one LL at a time
	 *  Traverse the second LL for every single outer node
	 *  when outer == inner
	 * 
	 * Time Complexity = O(m*n)
	 */
	public MySinglyNode intersectionMergePoint(MySinglyNode head1, MySinglyNode head2){
		MySinglyNode c1 = head1;
		MySinglyNode c2 = head2;
		while(c1 !=null){
			c1 = c1.getNext();
			while(c2 !=null){
				c2 = c2.getNext();
				if(c1 == c2){
					return c1;
				}
			}
		}
		return null;
	}
}
