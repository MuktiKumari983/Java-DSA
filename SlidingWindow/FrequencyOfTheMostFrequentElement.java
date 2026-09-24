// LeetCode 1838 - Frequency of the Most Frequent Element
// Topic: Sliding Window + Sorting + Prefix Sum
// Difficulty: Medium
// Time Complexity: O(n log n)
// Space Complexity: O(1) excluding sorting

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {

        // Sort so we can make smaller elements
        // equal to the largest element in the window
        Arrays.sort(nums);

        long sum = 0;
        int left = 0;
        int maxFrequency = 1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // Cost to make every element in the window
            // equal to nums[right]
            long cost = (long) nums[right] * (right - left + 1) - sum;

            // If cost is greater than k,
            // shrink the window
            while (cost > k) {

                sum -= nums[left];
                left++;

                cost = (long) nums[right] * (right - left + 1) - sum;
            }

            maxFrequency = Math.max(
                maxFrequency,
                right - left + 1
            );
        }

        return maxFrequency;
    }
}
