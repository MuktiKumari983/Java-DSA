// LeetCode 1314 - Matrix Block Sum
// Topic: 2D Prefix Sum
// Difficulty: Medium
// Time Complexity: O(m × n)
// Space Complexity: O(m × n)

/*
Approach:

1. Build a 2D prefix sum matrix.
2. For each cell (i, j), determine the boundaries
   of the block within distance k.
3. Use the 2D prefix sum to calculate the sum
   of that block in O(1).
4. Store the result in the answer matrix.

Formula:

Block Sum =
prefix[r2][c2]
- prefix[r1 - 1][c2]
- prefix[r2][c1 - 1]
+ prefix[r1 - 1][c1 - 1]

Example:

mat =

1 2 3
4 5 6
7 8 9

k = 1

Output:

12 21 16
27 45 33
24 39 28
*/

class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];
        int[][] ans = new int[m][n];

        // Build 2D Prefix Sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                prefix[i][j] =
                        mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        // Calculate Block Sum
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                r1++;
                c1++;
                r2++;
                c2++;

                ans[i][j] =
                        prefix[r2][c2]
                        - prefix[r1 - 1][c2]
                        - prefix[r2][c1 - 1]
                        + prefix[r1 - 1][c1 - 1];
            }
        }

        return ans;
    }
                  }
