class Solution {
    public int numberOfSubstrings(String s) {

        int[] count = new int[3]; // Count of a, b, c
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            count[s.charAt(right) - 'a']++;

            // If window contains a, b and c
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {

                // All substrings starting from 'left'
                // and ending at or after 'right' are valid
                result += s.length() - right;

                // Remove left character
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }
}
