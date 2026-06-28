// LeetCode 2100 - Find Good Days to Rob the Bank
// Topic: Prefix Sum, Prefix-Suffix Preprocessing
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

1. Create two arrays:
   - left[i]  = number of consecutive non-increasing
                days ending at i.
   - right[i] = number of consecutive non-decreasing
                days starting at i.

2. Traverse from left to right to fill left[].

3. Traverse from right to left to fill right[].

4. A day is a good day if:
      left[i] >= time
      &&
      right[i] >= time

5. Store all such indices.

Example:

security = [5,3,3,3,5,6,2]
time = 2

left:
0 1 2 3 0 0 1

right:
0 4 3 2 1 0 0

Answer:
[2,3]
*/

import java.util.*;

class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        int n = security.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {

            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {

            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (left[i] >= time && right[i] >= time) {
                ans.add(i);
            }
        }

        return ans;
    }
}
