// LeetCode 2017 - Grid Game
// Topic: Prefix Sum
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Calculate the total sum of the top row.
2. Initially, the bottom row sum is 0.
3. Traverse each possible column where
   Robot 1 can move down.
4. At every column:
   - Remove the current top cell from the
     remaining top sum.
   - The second robot can choose the larger of:
       a) Remaining top row
       b) Collected bottom row
   - Robot 1 wants to minimize this value.
   - Update the answer with the minimum.
   - Add the current bottom cell to the
     bottom prefix sum.
5. Return the minimum possible score for Robot 2.

Example:

Top Row:
[2,5,4]

Bottom Row:
[1,5,1]

Remaining Top and Bottom Prefix are compared
at every possible turning point.
*/

class Solution {

    public long gridGame(int[][] grid) {

        long topSum = 0;

        for (int num : grid[0]) {
            topSum += num;
        }

        long bottomSum = 0;
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {

            topSum -= grid[0][i];

            ans = Math.min(ans, Math.max(topSum, bottomSum));

            bottomSum += grid[1][i];
        }

        return ans;
    }
}
