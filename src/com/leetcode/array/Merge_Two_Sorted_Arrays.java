package com.leetcode.array;

/**
 * LeetCode: 88 (E)
 *  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *  Output: [1,2,2,3,5,6]
 */
public class Merge_Two_Sorted_Arrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int I = m + n - 1;
        while(m > 0 && n > 0){
            if(nums1[m - 1] < nums2[n - 1]){
                nums1[I] = nums2[n - 1];
                n--;
            } else {
                nums1[I] = nums1[m - 1];
                m--;
            }
            I--;
        }
        while(n > 0){
            nums1[I] = nums2[n - 1];
            n--;
            I--;
        }

        for(int i : nums1)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
}
