package com.leetcode.array;

/**
 * LeetCode: 167 (M)
 *  Input: numbers = [2,3,4], target = 6
 *  Output: [1,3]
 *  Explanation: The sum of 2 and 4 is 6. Therefore, index1 = 1, index2 = 3. We return [1, 3].
 */
public class Two_Sum_Sorted_Array {

    /*
     * Two Pointer Strategy
     *  Check for both the ends, and move the pointers accordingly
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left <= right){
            int currentSum = numbers[left] + numbers[right];
            if(currentSum == target){
                return new int[]{left + 1, right + 1};
            }
            if(currentSum > target){
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int targetSum = 13;
        int[] indexes = twoSum(numbers, targetSum);
        System.out.println(indexes[0] + " and " + indexes[1]);
    }
}
