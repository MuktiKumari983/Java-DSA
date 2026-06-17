// LeetCode 525 - Contiguous Array
// Topic: Prefix Sum, HashMap
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

1. Treat:
   0 as -1
   1 as +1

2. Maintain a running sum.

3. If the same sum appears again,
   the subarray between those indices
   contains equal numbers of 0s and 1s.

4. Store the first occurrence of each sum
   in a HashMap.

5. Update the maximum length whenever
   the same sum is encountered again.

Example:

nums = [0,1]

Convert:
[-1,+1]

Running Sum:
-1, 0

Sum 0 appears again,
therefore subarray length = 2.
*/

import java.util.HashMap;

class Solution {

    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {

                maxLen = Math.max(
                    maxLen,
                    i - map.get(sum)
                );

            } else {

                map.put(sum, i);
            }
        }

        return maxLen;
    }
                             }
