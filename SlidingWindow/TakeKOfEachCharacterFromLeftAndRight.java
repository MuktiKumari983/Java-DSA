// LeetCode 2516 - Take K of Each Character From Left and Right
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int takeCharacters(String s, int k) {

        int n = s.length();

        // Count total occurrences of a, b and c
        int[] total = new int[3];

        for (char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }

        // Not enough characters available
        if (total[0] < k || total[1] < k || total[2] < k) {
            return -1;
        }

        /*
         * We want to KEEP the longest middle window.
         *
         * Outside the window, we take characters from
         * the left and right.
         *
         * The outside must contain at least k of each character.
         *
         * Therefore, inside the window we can have at most:
         *
         * total[character] - k
         */

        int[] window = new int[3];

        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < n; right++) {

            window[s.charAt(right) - 'a']++;

            // Window contains too many of some character
            while (window[0] > total[0] - k ||
                   window[1] > total[1] - k ||
                   window[2] > total[2] - k) {

                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        // Characters taken from left + right
        return n - maxWindow;
    }
    }
