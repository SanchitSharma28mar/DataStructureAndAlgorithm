package com.leetcode.array;

/**
 * LeetCode: 26 (E)
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should be kept the same.
 * ---
 *  Input: nums = [0,0,1,1,1,2,2,3,3,4]
 *  Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 */
public class RemoveDuplicate_SortedArray {

    /*
     * 2 Pointer strategy.
     */
    private static int removeDuplicates(int[] nums) {
        if(nums.length == 1)
            return 1;

        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int index = removeDuplicates(nums);
        System.out.println("Index till elements are unique = " + index);
        for(int i = 0; i < index; i++)
            System.out.print(nums[i] + " ");
    }
}
