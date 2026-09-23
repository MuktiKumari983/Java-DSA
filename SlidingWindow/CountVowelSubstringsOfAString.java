// LeetCode 2062 - Count Vowel Substrings of a String
// Topic: Sliding Window
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int countVowelSubstrings(String word) {

        int count = 0;

        for (int left = 0; left < word.length(); left++) {

            // A vowel substring cannot contain a consonant
            if (!isVowel(word.charAt(left))) {
                continue;
            }

            boolean[] seen = new boolean[5];
            int distinct = 0;

            for (int right = left; right < word.length(); right++) {

                char ch = word.charAt(right);

                // Stop when a consonant is found
                if (!isVowel(ch)) {
                    break;
                }

                int index = getIndex(ch);

                if (!seen[index]) {
                    seen[index] = true;
                    distinct++;
                }

                // All 5 vowels are present
                if (distinct == 5) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }

    private int getIndex(char ch) {
        if (ch == 'a') return 0;
        if (ch == 'e') return 1;
        if (ch == 'i') return 2;
        if (ch == 'o') return 3;
        return 4;
    }
}
