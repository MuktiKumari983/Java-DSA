// LeetCode 1004 - Max Consecutive Ones III
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

We can change at most k zeros into ones.

So, maintain a sliding window containing
at most k zeros.

Steps:

1. Expand the window using right.
2. If nums[right] is 0, increase zeroCount.
3. If zeroCount > k:
      Shrink the window from the left.
4. While shrinking, if nums[left] is 0,
      decrease zeroCount.
5. Update the maximum window length.

Example:

nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

We can flip at most 2 zeros.

The longest valid window contains
at most 2 zeros.

Answer = 6
*/

class Solution {

    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}
