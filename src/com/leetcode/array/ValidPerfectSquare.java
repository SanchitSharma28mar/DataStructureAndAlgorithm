package com.leetcode.array;

/**
 * LeetCode: 367 (E)
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 */
public class ValidPerfectSquare {

    /*
     * Use Binary Search to cut down the number of integers for which square is to be done
     */
    private static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;

        while(left <= right){
            int mid = (left + right)/2;
            if(mid * mid < num){
                left = mid + 1;
            } else if(mid * mid > num){
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(14));
    }
}
