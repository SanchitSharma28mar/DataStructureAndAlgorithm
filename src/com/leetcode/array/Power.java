package com.leetcode.array;

/**
 * LeetCode: 50 (M)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
public class Power {

    private static double myPow(double x, int n) {
        double answer = 1;
        for(int i=0; i< Math.abs(n); i++){
            answer = answer * x;
        }
        return n > 0 ? answer : 1.0/answer;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 4));
    }
}
