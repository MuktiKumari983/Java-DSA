// LeetCode 1052 - Grumpy Bookstore Owner
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;

        // Customers already satisfied normally
        int satisfied = 0;

        // Extra customers we can satisfy using the technique
        int window = 0;

        // First window
        for (int i = 0; i < minutes; i++) {

            if (grumpy[i] == 1) {
                window += customers[i];
            }
        }

        int maxWindow = window;

        // Slide the window
        for (int i = minutes; i < n; i++) {

            // Add the new element
            if (grumpy[i] == 1) {
                window += customers[i];
            }

            // Remove the element leaving the window
            if (grumpy[i - minutes] == 1) {
                window -= customers[i - minutes];
            }

            maxWindow = Math.max(maxWindow, window);
        }

        // Customers satisfied without using the technique
        for (int i = 0; i < n; i++) {

            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        return satisfied + maxWindow;
    }
          }
