// LeetCode 121 - Best Time to Buy and Sell Stock
// Topic: Array, Running Minimum
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:
1. Maintain the minimum stock price seen so far.
2. For each day, calculate potential profit.
3. Update maximum profit if current profit is larger.
4. Return the maximum profit.
*/

class Solution {
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            min = Math.min(min, prices[i]);

            int profit = prices[i] - min;

            max = Math.max(max, profit);
        }

        return max;
    }
}
