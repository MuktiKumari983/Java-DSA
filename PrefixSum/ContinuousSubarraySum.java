// LeetCode 523 - Continuous Subarray Sum
// Topic: Prefix Sum, HashMap
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(min(n, k))

/*
Approach:

1. Compute the running prefix sum.
2. Store the first occurrence of each remainder
   (prefixSum % k) in a HashMap.
3. If the same remainder appears again,
   the sum of elements between those indices
   is divisible by k.
4. Ensure the subarray length is at least 2.

Example:

nums = [23,2,4,6,7]
k = 6

Prefix Sum:
23 -> rem = 5
25 -> rem = 1
29 -> rem = 5

Since remainder 5 appears twice,
the subarray between them has sum divisible by 6.
*/

import java.util.HashMap;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int rem = prefix % k;

            if (map.containsKey(rem)) {

                if (i - map.get(rem) >= 2) {
                    return true;
                }

            } else {

                map.put(rem, i);
            }
        }

        return false;
    }
}
