// LeetCode 1695 - Maximum Erasure Value
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove duplicates from the left
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            sum += nums[right];

            // Update maximum sum
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
             }
