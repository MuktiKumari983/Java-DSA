// LeetCode 1672 - Richest Customer Wealth
// Topic: 2D Array Traversal
// Difficulty: Easy
// Time Complexity: O(m * n)
// Space Complexity: O(1)

/*
Approach:
1. Traverse each row (customer).
2. Calculate the sum of all accounts in that row.
3. Keep track of the maximum sum.
4. Return the maximum wealth found.
*/

class Solution {
    public int maximumWealth(int[][] accounts) {

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < accounts.length; i++) {

            int sum = 0;

            for(int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
