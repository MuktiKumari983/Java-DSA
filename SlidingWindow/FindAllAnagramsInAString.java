// LeetCode 438 - Find All Anagrams in a String
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

An anagram has exactly the same frequency of
each character.

Example:

p = "ab"

Anagrams:

"ab"
"ba"

Maintain a fixed-size window of length p.length()
inside string s.

Steps:

1. Store the frequency of characters in p.
2. Create a window of the same size in s.
3. Maintain the frequency of characters in the window.
4. When the window has the same frequency as p,
   add its starting index to the answer.
5. Slide the window by:
      - Removing the outgoing character.
      - Adding the incoming character.

Example:

s = "cbaebabacd"
p = "abc"

Valid windows:

"cba" -> anagram -> index 0

"bae" -> not anagram

...

"bac" -> anagram -> index 6

Answer = [0, 6]
*/

import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of characters in p
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        int k = p.length();

        // First window
        for (int i = 0; i < k; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, windowFreq)) {
            ans.add(0);
        }

        // Slide the window
        for (int i = k; i < s.length(); i++) {

            // Remove outgoing character
            windowFreq[s.charAt(i - k) - 'a']--;

            // Add incoming character
            windowFreq[s.charAt(i) - 'a']++;

            if (Arrays.equals(pFreq, windowFreq)) {
                ans.add(i - k + 1);
            }
        }

        return ans;
    }
          }
