// LeetCode 1176 - Diet Plan Performance
// Topic: Sliding Window
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int sum = 0;
        int points = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }

        // Calculate points for first window
        if (sum < lower) {
            points--;
        } else if (sum > upper) {
            points++;
        }

        // Slide the window
        for (int i = k; i < calories.length; i++) {

            // Add new element
            sum += calories[i];

            // Remove element leaving the window
            sum -= calories[i - k];

            // Calculate points
            if (sum < lower) {
                points--;
            } else if (sum > upper) {
                points++;
            }
        }

        return points;
    }
}
