package com.leetcode.string.blind;

/**
 * LeetCode: 125 (E)
 * ---
 *  Input: s = "A man, a plan, a canal: Panama"
 *  Output: true
 *  Explanation: "amanaplanacanalpanama" is a palindrome.
 * ---
 *  Input: s = "race a car"
 *  Output: false
 *  Explanation: "raceacar" is not a palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
       String s = "A man, a plan, a canal: Panama";
       System.out.println(isPalindrome(s));
    }
    private static boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while(leftIndex < rightIndex){
            char charAtLeftIndex = s.charAt(leftIndex);
            char charAtRightIndex = s.charAt(rightIndex);
            if(!Character.isLetterOrDigit(charAtLeftIndex)){
                leftIndex++;
                continue;
            }
            if(!Character.isLetterOrDigit(charAtRightIndex)){
                rightIndex--;
                continue;
            }
            if(Character.toLowerCase(charAtLeftIndex) != Character.toLowerCase(charAtRightIndex)){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
