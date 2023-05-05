package com.leetcode.array;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * LeetCode: 215 (M)
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * ---
 *  Input: nums = [3,2,1,5,6,4], k = 2
 *  Output: 5
 */
public class Kth_Largest_Element {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int kThLargest_Sort = findKthLargest_Sort(nums, k);
        System.out.println(kThLargest_Sort);

//        int kThLargest_Heap = findKthLargest_Heap(nums, k);
//        System.out.println(kThLargest_Heap);

//        int kThLargest_QuickSelect = findKthLargest_QuickSelect(nums, k);
//        System.out.println(kThLargest_QuickSelect);
    }

    private static int findKthLargest_Sort(int[] nums, int k) {
        Instant start = Instant.now();

        Arrays.sort(nums);
        int index = nums.length - k;
        int kTh = nums[index];

        Instant end = Instant.now();
        System.out.println("Time taken - " + Duration.between(start, end).toNanos() + " ns");
        return kTh;
    }

//    private static int findKthLargest_Heap(int[] nums, int k) {
//        Instant start = Instant.now();
//
//
//        Instant end = Instant.now();
//        System.out.println("Time taken - " + Duration.between(start, end).toMillis() + " ms");
//        return 0;
//    }

    private static int findKthLargest_QuickSelect(int[] nums, int k) {
        Instant start = Instant.now();


        Instant end = Instant.now();
        System.out.println("Time taken - " + Duration.between(start, end).toMillis() + " ms");
        return 0;
    }
}
