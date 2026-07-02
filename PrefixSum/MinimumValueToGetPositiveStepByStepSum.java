// LeetCode 1413 - Minimum Value to Get Positive Step by Step Sum
// Topic: Prefix Sum, Running Minimum
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Calculate the running prefix sum.
2. Keep track of the minimum prefix sum.
3. If the minimum prefix sum becomes negative,
   choose a startValue so that it becomes at least 1.

Formula:
Answer = 1 - minimumPrefixSum

Example:

nums = [-3,2,-3,4,2]

Prefix Sums:
-3, -1, -4, 0, 2

Minimum Prefix Sum = -4

Required Start Value:
1 - (-4) = 5
*/

class Solution {

    public int minStartValue(int[] nums) {

        int sum = 0;
        int min = 0;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }

        return 1 - min;
    }
}
