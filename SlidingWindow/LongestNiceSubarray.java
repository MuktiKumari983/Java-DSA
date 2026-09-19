// LeetCode 2401 - Longest Nice Subarray
// Topic: Sliding Window + Bit Manipulation
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int longestNiceSubarray(int[] nums) {

        int left = 0;
        int usedBits = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // If common bit exists, window is not nice
            while ((usedBits & nums[right]) != 0) {

                // Remove nums[left] from the window
                usedBits ^= nums[left];
                left++;
            }

            // Add current number's bits
            usedBits |= nums[right];

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
          }
