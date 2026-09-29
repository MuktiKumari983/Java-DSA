import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If more than k distinct characters,
            // shrink the window from the left
            while (map.size() > k) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                // Remove character completely when its
                // frequency becomes zero
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            // Current window has at most k distinct characters
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
