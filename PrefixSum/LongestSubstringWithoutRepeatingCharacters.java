// LeetCode 3 - Longest Substring Without Repeating Characters
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

Maintain a variable-size sliding window.

Use a HashSet to store characters currently
inside the window.

Steps:

1. Expand the window by moving the right pointer.
2. If a duplicate character is found:
      - Remove characters from the left
        until the duplicate is removed.
3. Update the maximum window length.

Example:

s = "abcabcbb"

Window:

"a"      -> 1

"ab"     -> 2

"abc"    -> 3

"abca"
Duplicate 'a'

Remove 'a'

Window becomes:

"bca"

Continue...

Answer = 3
*/

import java.util.HashSet;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {

                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
                                }
