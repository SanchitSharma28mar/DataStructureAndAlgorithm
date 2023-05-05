package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 * LeetCode: 703 (E)
 * Kth Largest Element in a Stream.
 */
public class KthLargest_InStream {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest_InStream(int k, int[] nums){
        this.k = k;
        for(int num : nums)
            add(num);
    }

    public int add(int val) {
        if(pq.size() < k) {
            pq.offer(val);
        } else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
