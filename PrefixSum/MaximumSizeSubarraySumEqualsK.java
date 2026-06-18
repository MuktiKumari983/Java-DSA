// LeetCode 325 - Maximum Size Subarray Sum Equals K
// Topic: Prefix Sum, HashMap
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

1. Maintain a running prefix sum.
2. If prefixSum - k has appeared before,
   then the subarray between those indices
   has sum exactly equal to k.
3. Store the first occurrence of each
   prefix sum in a HashMap.
4. Update the maximum length whenever
   a valid subarray is found.

Example:

nums = [1, -1, 5, -2, 3]
k = 3

Prefix Sums:
1, 0, 5, 3, 6

At index 3:
prefixSum = 3

prefixSum - k = 0

0 was seen at index -1

Length = 3 - (-1) = 4
*/

import java.util.HashMap;

class Solution {

    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefix = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            if (map.containsKey(prefix - k)) {

                maxLen = Math.max(
                    maxLen,
                    i - map.get(prefix - k)
                );
            }

            map.putIfAbsent(prefix, i);
        }

        return maxLen;
    }
                                }
