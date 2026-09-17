// LeetCode 1208 - Get Equal Substrings Within Budget
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int left = 0;
        int cost = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Cost of changing s[right] to t[right]
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            // If cost exceeds budget, shrink the window
            while (cost > maxCost) {
                cost -= Math.abs(
                    s.charAt(left) - t.charAt(left)
                );
                left++;
            }

            // Current window is valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
                  }
