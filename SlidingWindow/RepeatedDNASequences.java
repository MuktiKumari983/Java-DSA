// LeetCode 187 - Repeated DNA Sequences
// Topic: Sliding Window + HashSet
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

Every DNA sequence has exactly 10 characters.

So, use a fixed-size sliding window of size 10.

Maintain two HashSets:

seen     -> sequences seen for the first time
repeated -> sequences that appear more than once

Steps:

1. Start from index 0.
2. Extract a substring of length 10.
3. If it has already appeared in 'seen',
   add it to 'repeated'.
4. Otherwise, add it to 'seen'.
5. Move the window one position forward.

Example:

s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Repeated sequences:

"AAAAACCCCC"
"CCCCCAAAAA"

Answer = ["AAAAACCCCC", "CCCCCAAAAA"]
*/

import java.util.*;

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> ans = new ArrayList<>();

        if (s.length() < 10) {
            return ans;
        }

        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String sequence = s.substring(i, i + 10);

            if (seen.contains(sequence)) {
                repeated.add(sequence);
            } else {
                seen.add(sequence);
            }
        }

        ans.addAll(repeated);

        return ans;
    }
                                                 }
