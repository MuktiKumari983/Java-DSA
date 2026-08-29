// LeetCode 567 - Permutation in String
// Topic: Sliding Window + Hashing
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Store frequency of characters in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int k = s1.length();

        // First window
        for (int i = 0; i < k; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the window
        for (int i = k; i < s2.length(); i++) {

            // Remove outgoing character
            windowFreq[s2.charAt(i - k) - 'a']--;

            // Add incoming character
            windowFreq[s2.charAt(i) - 'a']++;

            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {

            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
