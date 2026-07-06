// LeetCode 2574 - Left and Right Sum Differences
// Topic: Prefix Sum
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

1. Build the left sum array.
2. Build the right sum array.
3. For each index,
   answer[i] = |leftSum - rightSum|.

Example:

nums = [10,4,8,3]

Left Sum:
[0,10,14,22]

Right Sum:
[15,11,3,0]

Answer:
[15,1,11,22]
*/

class Solution {

    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(left[i] - right[i]);
        }

        return answer;
    }
}
