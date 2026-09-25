// LeetCode 76 - Minimum Window Substring
// Topic: Sliding Window
// Difficulty: Hard
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public String minWindow(String s, String t) {

        // Frequency of characters required from t
        int[] required = new int[128];

        for (char ch : t.toCharArray()) {
            required[ch]++;
        }

        int left = 0;
        int count = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If this character is still needed,
            // it contributes to satisfying t
            if (required[ch] > 0) {
                count++;
            }

            // Include character in the current window
            required[ch]--;

            // Window contains all characters of t
            while (count == t.length()) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                required[leftChar]++;

                // If it becomes positive, the window
                // is missing this required character
                if (required[leftChar] > 0) {
                    count--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
  }
