// LeetCode 2270 - Number of Ways to Split Array
// Topic: Prefix Sum
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Calculate the total sum of the array.
2. Maintain a running prefix sum.
3. Compute suffix sum as:
      suffix = total - prefix
4. If prefix >= suffix,
   then the split is valid.
5. Count all valid splits.

Example:

nums = [10,4,-8,7]

i = 0
prefix = 10
suffix = 3
Valid Split

i = 1
prefix = 14
suffix = -1
Valid Split

i = 2
prefix = 6
suffix = 7
Invalid Split

Answer = 2
*/

class Solution {

    public int waysToSplitArray(int[] nums) {

        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long prefix = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            prefix += nums[i];

            long suffix = total - prefix;

            if (prefix >= suffix) {
                count++;
            }
        }

        return count;
    }
}
