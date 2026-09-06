// LeetCode 1151 - Minimum Swaps to Group All 1's Together
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minSwaps(int[] data) {

        // Count total number of 1's
        int ones = 0;

        for (int num : data) {
            if (num == 1) {
                ones++;
            }
        }

        // If there are 0 or 1 ones, no swaps are needed
        if (ones <= 1) {
            return 0;
        }

        // Count zeros in the first window of size 'ones'
        int zeros = 0;

        for (int i = 0; i < ones; i++) {
            if (data[i] == 0) {
                zeros++;
            }
        }

        int minSwaps = zeros;

        // Slide the window
        for (int i = ones; i < data.length; i++) {

            // Add the new element
            if (data[i] == 0) {
                zeros++;
            }

            // Remove the element leaving the window
            if (data[i - ones] == 0) {
                zeros--;
            }

            // Minimum zeros inside a window = minimum swaps
            minSwaps = Math.min(minSwaps, zeros);
        }

        return minSwaps;
    }
}
