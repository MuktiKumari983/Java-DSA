// LeetCode 169 - Majority Element
// Topic: Arrays, Frequency Counting
// Difficulty: Easy
// Time Complexity: O(n²)
// Space Complexity: O(1)

/*
Approach:
1. For each element, count its occurrences in the array.
2. If the count becomes greater than n/2, return that element.
3. The problem guarantees that a majority element always exists.

Example:
Input: [3,2,3]
Output: 3

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        int ans = n / 2;

        for (int j = 0; j < nums.length; j++) {

            int count = 0;

            for (int i = j; i < nums.length; i++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > ans) {
                return nums[j];
            }
        }

        return -1;
    }
}
