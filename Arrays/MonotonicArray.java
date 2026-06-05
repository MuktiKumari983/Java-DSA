// LeetCode 896 - Monotonic Array
// Topic: Arrays, Traversal
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:
1. Assume the array is both increasing and decreasing.
2. Traverse the array once.
3. If nums[i] > nums[i+1], it cannot be increasing.
4. If nums[i] < nums[i+1], it cannot be decreasing.
5. If either increasing or decreasing remains true, the array is monotonic.

Example:
Input: [1,2,2,3]
Output: true

Input: [6,5,4,4]
Output: true

Input: [1,3,2]
Output: false
*/

class Solution {
    public boolean isMonotonic(int[] nums) {

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                inc = false;
            }

            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }

        return inc || dec;
    }
}
