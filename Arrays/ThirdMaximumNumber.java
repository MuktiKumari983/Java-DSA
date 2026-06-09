// LeetCode 414 - Third Maximum Number
// Topic: Arrays, HashSet
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:
1. Store all elements in a HashSet to remove duplicates.
2. Find the maximum element.
3. If there are fewer than 3 distinct elements,
   return the maximum element.
4. Otherwise remove the first and second maximums.
5. Return the third maximum.

Example:
Input: [3,2,1]
Output: 1

Input: [1,2]
Output: 2
*/

import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max1 = Collections.max(set);

        if (set.size() < 3) {
            return max1;
        }

        set.remove(max1);

        int max2 = Collections.max(set);
        set.remove(max2);

        int max3 = Collections.max(set);

        return max3;
    }
}
