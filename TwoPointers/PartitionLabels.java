// LeetCode 763 - Partition Labels
// Topic: Greedy + Two Pointers
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Store the last occurrence of every character.
2. Traverse the string.
3. Keep updating the current partition's ending index.
4. When the current index reaches the ending index,
   we have found one complete partition.
5. Store its length and start a new partition.

Example:

s = "ababcbacadefegdehijhklij"

Last Occurrence:

a -> 8
b -> 5
c -> 7
...

Partition 1:
ababcbaca
Length = 9

Partition 2:
defegde
Length = 7

Partition 3:
hijhklij
Length = 8

Answer = [9,7,8]
*/

import java.util.*;

class Solution {

    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {

                ans.add(end - start + 1);

                start = i + 1;
            }
        }

        return ans;
    }
}
