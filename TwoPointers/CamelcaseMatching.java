// LeetCode 1023 - Camelcase Matching
// Topic: String + Two Pointers
// Difficulty: Medium
// Time Complexity: O(n × m)
// Space Complexity: O(1)

/*
Approach:

For each query:

1. Use two pointers:
      i -> query
      j -> pattern

2. If characters match:
      Move both pointers.

3. If they don't match:

      If query[i] is lowercase,
      skip it.

      If query[i] is uppercase,
      return false because every
      uppercase letter must match
      the pattern.

4. After traversing the query,
   the pattern must also be completely matched.

Example:

queries = ["FooBar","FooBarTest","FootBall"]

pattern = "FB"

Answer:

true
false
true
*/

import java.util.*;

class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            ans.add(match(query, pattern));
        }

        return ans;
    }

    private boolean match(String query, String pattern) {

        int i = 0;
        int j = 0;

        while (i < query.length()) {

            if (j < pattern.length() &&
                query.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

            } else {

                if (Character.isUpperCase(query.charAt(i))) {
                    return false;
                }

                i++;
            }
        }

        return j == pattern.length();
    }
}
