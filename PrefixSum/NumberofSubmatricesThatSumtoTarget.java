// LeetCode 1074 - Number of Submatrices That Sum to Target
// Topic: Prefix Sum, HashMap, Matrix
// Difficulty: Hard
// Time Complexity: O(cols² × rows)
// Space Complexity: O(rows)

/*
Approach:

1. Fix two column boundaries
   (left and right).

2. For every row, calculate the
   sum of elements between these
   two columns.

3. Now the 2D problem becomes a
   1D problem:
   Count the number of subarrays
   whose sum equals target.

4. Use Prefix Sum + HashMap to
   count subarrays efficiently.

5. Repeat for every pair of
   columns and add all valid
   submatrices.

Example:

matrix =
[
 [1, -1],
 [-1, 1]
]

target = 0

Column Pair (0,1)

Row sums:
0
0

Now find subarrays with sum = 0.

Prefix Sums:
0 → count = 1
0 → answer += 1
0 → answer += 2

Total = 3 submatrices.
*/

import java.util.HashMap;

class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int answer = 0;

        for (int left = 0; left < cols; left++) {

            int[] rowSum = new int[rows];

            for (int right = left; right < cols; right++) {

                for (int row = 0; row < rows; row++) {
                    rowSum[row] += matrix[row][right];
                }

                HashMap<Integer, Integer> map = new HashMap<>();

                map.put(0, 1);

                int prefix = 0;

                for (int value : rowSum) {

                    prefix += value;

                    answer += map.getOrDefault(prefix - target, 0);

                    map.put(prefix,
                            map.getOrDefault(prefix, 0) + 1);
                }
            }
        }

        return answer;
    }
}
