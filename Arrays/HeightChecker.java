// LeetCode 1051 - Height Checker
// Topic: Arrays, Sorting
// Difficulty: Easy
// Time Complexity: O(n log n)
// Space Complexity: O(n)

/*
Approach:
1. Create a copy of the original array.
2. Sort the copied array.
3. Compare the original array with the sorted array.
4. Count the indices where the elements differ.
5. Return the count.

Example:
Input: [1,1,4,2,1,3]
Output: 3

Explanation:
Expected order after sorting: [1,1,1,2,3,4]
Mismatch positions = 3
*/

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {

        int n = heights.length;
        int[] heights2 = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            heights2[i] = heights[i];
        }

        Arrays.sort(heights2);

        for (int i = 0; i < n; i++) {
            if (heights[i] != heights2[i]) {
                count++;
            }
        }

        return count;
    }
}
