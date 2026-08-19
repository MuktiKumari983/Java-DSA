// LeetCode 209 - Minimum Size Subarray Sum
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

We need to find the minimum length of a contiguous
subarray whose sum is greater than or equal to target.

Use a variable-size sliding window.

Steps:

1. Expand the window using the right pointer.
2. Add nums[right] to the current sum.
3. Whenever sum >= target:
      - Update the minimum length.
      - Remove nums[left].
      - Move left forward.
4. Continue until the end.

Example:

target = 7
nums = [2,3,1,2,4,3]

Possible valid windows:

[2,3,1,2] -> sum = 8 -> length 4
[3,1,2,4] -> sum = 10 -> length 4
[4,3]     -> sum = 7 -> length 2

Answer = 2
*/

class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLength = Math.min(
                    minLength,
                    right - left + 1
                );

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
