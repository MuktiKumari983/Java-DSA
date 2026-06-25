// LeetCode 1732 - Find the Highest Altitude
// Topic: Prefix Sum
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

1. The biker starts at altitude 0.
2. Each gain[i] changes the current altitude.
3. Build the altitude at every point using prefix sums.
4. Track the maximum altitude encountered.
5. Return the highest altitude.

Example:

gain = [-5,1,5,0,-7]

Altitudes:
0, -5, -4, 1, 1, -6

Highest Altitude = 1
*/

class Solution {

    public int largestAltitude(int[] gain) {

        int n = gain.length;

        int max = 0;

        int[] arr = new int[n + 1];

        arr[0] = 0;

        for (int i = 0; i < gain.length; i++) {

            arr[i + 1] = arr[i] + gain[i];

            max = Math.max(max, arr[i + 1]);
        }

        return max;
    }
}
