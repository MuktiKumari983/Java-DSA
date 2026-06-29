// LeetCode 2483 - Minimum Penalty for a Shop
// Topic: Prefix Sum, Prefix-Suffix Counting
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Assume the shop closes after the last hour.
   Initial penalty = total number of 'N'.

2. Traverse each possible closing hour.

3. If the current customer is:
   - 'Y' : Keeping the shop open avoids one penalty,
           so decrease penalty by 1.
   - 'N' : Keeping the shop open creates one extra penalty,
           so increase penalty by 1.

4. Track the minimum penalty and the earliest
   closing hour where it occurs.

Example:

customers = "YYNY"

Initial penalty = Number of 'N' = 1

Hour 1 -> penalty = 0
Hour 2 -> penalty = -1
Hour 3 -> penalty = 0
Hour 4 -> penalty = -1

Minimum penalty occurs at the earliest valid hour.
*/

class Solution {

    public int bestClosingTime(String customers) {

        int penalty = 0;

        for (char c : customers.toCharArray()) {
            if (c == 'N') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int answer = 0;

        for (int i = 0; i < customers.length(); i++) {

            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                answer = i + 1;
            }
        }

        return answer;
    }
}
