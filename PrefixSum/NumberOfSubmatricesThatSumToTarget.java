// LeetCode 1074 - Number of Submatrices That Sum to Target
// Topic: 2D Prefix Sum, HashMap
// Difficulty: Hard
// Time Complexity: O(cols² × rows)
// Space Complexity: O(rows)

/*
Approach:

1. Compute prefix sums for each row.
2. Fix two column boundaries (left and right).
3. Compress the 2D matrix into a 1D array by
   summing elements between the two columns.
4. The problem becomes:
   "Count subarrays whose sum equals target."
5. Use Prefix Sum + HashMap to count such
   subarrays efficiently.
6. Repeat for every pair of columns.

Example:

Matrix:

1 -1
-1 1

Target = 0

Possible submatrices with sum 0 are counted
using row compression and Prefix Sum.
*/

import java.util.HashMap;

class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Row-wise Prefix Sum
        for (int r = 0; r < rows; r++) {

            for (int c = 1; c < cols; c++) {

                matrix[r][c] += matrix[r][c - 1];
            }
        }

        int count = 0;

        for (int left = 0; left < cols; left++) {

            for (int right = left; right < cols; right++) {

                HashMap<Integer, Integer> map = new HashMap<>();

                map.put(0, 1);

                int prefix = 0;

                for (int r = 0; r < rows; r++) {

                    int sum = matrix[r][right];

                    if (left > 0) {
                        sum -= matrix[r][left - 1];
                    }

                    prefix += sum;

                    count += map.getOrDefault(prefix - target, 0);

                    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
                }
            }
        }

        return count;
    }
}
