// LeetCode 53 - Maximum Subarray
// Topic: Arrays, Kadane's Algorithm
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:
1. Maintain the maximum sum ending at the current index.
2. For each element, either:
   - Extend the current subarray, or
   - Start a new subarray from the current element.
3. Keep track of the overall maximum subarray sum.
4. Return the maximum sum found.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4]
Output: 6

Explanation:
The subarray [4,-1,2,1] has the largest sum = 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {

        int maxEnding = nums[0];
        int maxAns = nums[0];

        for (int i = 1; i < nums.length; i++) {

            maxEnding = Math.max(maxEnding + nums[i], nums[i]);

            maxAns = Math.max(maxAns, maxEnding);
        }

        return maxAns;
    }
}
