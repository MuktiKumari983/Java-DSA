// LeetCode 713 - Subarray Product Less Than K
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

Maintain a sliding window whose product is less than k.

Steps:

1. Expand the window by multiplying nums[right].
2. If product >= k:
      Shrink the window from the left.
3. Once product < k, all subarrays ending at right
   and starting from left to right are valid.

Number of valid subarrays ending at right:

right - left + 1

Example:

nums = [10, 5, 2, 6]
k = 100

Valid subarrays:

[10]
[5]
[2]
[6]
[10,5]
[5,2]
[2,6]
[5,2,6]
[10,5,2] -> product 100, invalid

Answer = 8
*/

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            product *= nums[right];

            while (product >= k) {

                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
