// LeetCode 930 - Binary Subarrays With Sum
// Topic: Prefix Sum
// Difficulty: Medium
// Time Complexity: O(n²)
// Space Complexity: O(1)

/*
Approach (Brute Force):

1. Consider every possible starting index.
2. Extend the subarray one element at a time.
3. Keep a running sum.
4. If the running sum equals the goal,
   increment the count.
5. Return the total number of valid subarrays.

Example:

nums = [1,0,1,0,1]
goal = 2

Valid Subarrays:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]

Answer = 4
*/

class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum == goal) {
                    count++;
                }
            }
        }

        return count;
    }
}
