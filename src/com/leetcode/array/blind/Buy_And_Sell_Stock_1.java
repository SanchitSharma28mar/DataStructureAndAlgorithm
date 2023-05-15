package com.leetcode.array.blind;

/**
 * LeetCode: 121 (E)
 *  You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *  ---
 *  Input: prices = [7,1,5,3,6,4]
 *  Output: 5
 *  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *  Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class Buy_And_Sell_Stock_1 {
    public static void main(String[] args) {
        int[] prices = {7, 1 ,5 ,3 ,6 ,4};
        System.out.println(maxProfit(prices));
    }
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        int currentProfit = 0;
        while(right < prices.length){
            if(prices[right] >= prices[left]){
                currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else if(prices[right] < prices[left]){
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
