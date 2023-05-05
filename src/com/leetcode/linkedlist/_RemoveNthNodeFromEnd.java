package com.leetcode.linkedlist;

import com.datastructure.linkedlist.impl.MySinglyNode;

/**
 * LeetCode: 19 (M)
 */
public class _RemoveNthNodeFromEnd {

    public MySinglyNode removeNthFromEnd(MySinglyNode head, int n) {
        MySinglyNode p1 = head;
        MySinglyNode p2 = head;
        for(int i = 0; i < n; i++){
            p1 = p1.getNext();
        }
        while(p1 != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        p2.setData(p1);
        return head;
    }
}
