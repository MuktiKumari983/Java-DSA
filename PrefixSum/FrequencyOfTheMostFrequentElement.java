// LeetCode 1838 - Frequency of the Most Frequent Element
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n log n)
// Space Complexity: O(1) extra space

import java.util.Arrays;

class Solution {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        long sum = 0;
        int left = 0;
        int maxFrequency = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // Cost to make every element in the window
            // equal to nums[right]
            long cost = (long) nums[right] * (right - left + 1) - sum;

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
