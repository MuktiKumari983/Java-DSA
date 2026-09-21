// LeetCode 978 - Longest Turbulent Subarray
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int left = 0;
        int maxLength = 1;

        for (int right = 1; right < arr.length; right++) {

            // Check whether the current comparison
            // and previous comparison are opposite
            if (right == 1 ||
                (arr[right - 1] > arr[right] &&
                 arr[right - 2] < arr[right - 1]) ||
                (arr[right - 1] < arr[right] &&
                 arr[right - 2] > arr[right - 1])) {

                maxLength = Math.max(maxLength, right - left + 1);

            } else {
                // Current turbulent pattern is broken
                left = right - 1;
            }
        }

        return maxLength;
    }
                 }
