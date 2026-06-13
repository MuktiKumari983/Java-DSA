// LeetCode 724 - Find Pivot Index
// Topic: Prefix Sum
// Difficulty: Easy
// Time Complexity: O(n²)
// Space Complexity: O(1)

/*
Approach:
1. For every index, calculate:
   - Sum of elements on the left.
   - Sum of elements on the right.
2. If both sums are equal, return the index.
3. Return the leftmost pivot index.
4. If no pivot index exists, return -1.

Example:
Input: [1,7,3,6,5,6]
Output: 3

Explanation:
Left Sum = 1 + 7 + 3 = 11
Right Sum = 5 + 6 = 11
*/

class Solution {
    public int pivotIndex(int[] nums) {

        for (int j = 0; j < nums.length; j++) {

            int sumF = 0;
            int sumE = 0;

            for (int i = 0; i < j; i++) {
                sumF += nums[i];
            }

            for (int k = j + 1; k < nums.length; k++) {
                sumE += nums[k];
            }

            if (sumF == sumE) {
                return j;
            }
        }

        return -1;
    }
}
