// LeetCode 1652 - Defuse the Bomb
// Topic: Sliding Window
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

There are three cases:

1. k == 0
   Every answer is 0.

2. k > 0
   Sum the next k elements.

3. k < 0
   Sum the previous |k| elements.

Since the array is circular,
use modulo (%) to wrap around.

Example:

code = [5,7,1,4]

k = 3

For index 0:

7 + 1 + 4 = 12

For index 1:

1 + 4 + 5 = 10

Answer:

[12,10,16,13]
*/

class Solution {

    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) {
            return ans;
        }

        int start, end;

        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = k;
            end = -1;
        }

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += code[(i + n) % n];
        }

        for (int i = 0; i < n; i++) {

            ans[i] = sum;

            sum -= code[(start + i + n) % n];

            start++;
            end++;

            sum += code[(end + i + n) % n];
        }

        return ans;
    }
}
