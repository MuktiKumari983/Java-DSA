// LeetCode 1456 - Maximum Number of Vowels in a Substring of Given Length
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

We need the maximum number of vowels in any substring
of length k.

Maintain a fixed-size sliding window.

Steps:

1. Count vowels in the first window of size k.
2. Store it as the current maximum.
3. Slide the window:
      - Remove the left character if it is a vowel.
      - Add the new right character if it is a vowel.
4. Update the maximum vowel count.
5. Return the maximum.

Example:

s = "abciiidef"

k = 3

Windows:

"abc" -> 1 vowel

"bci" -> 1 vowel

"cii" -> 2 vowels

"iii" -> 3 vowels

Answer = 3
*/

class Solution {

    public int maxVowels(String s, int k) {

        int count = 0;

        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int maxCount = count;

        for (int i = k; i < s.length(); i++) {

            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            if (isVowel(s.charAt(i))) {
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private boolean isVowel(char ch) {

        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    }
}
