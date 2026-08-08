// LeetCode 1343 - Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Average >= threshold
        // sum / k >= threshold
        // sum >= k * threshold
        if (sum >= k * threshold) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            sum = sum - arr[i - k] + arr[i];

            if (sum >= k * threshold) {
                count++;
            }
        }

        return count;
    }
}
