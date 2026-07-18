// LeetCode 15 - 3Sum
// Topic: Two Pointers
// Difficulty: Medium
// Time Complexity: O(n²)
// Space Complexity: O(1) (excluding the output list)

/*
Approach:

1. Sort the array.
2. Fix one element at index i.
3. Use two pointers:
      left = i + 1
      right = n - 1
4. Find pairs whose sum equals -nums[i].
5. Skip duplicate values to avoid duplicate triplets.

Example:

nums = [-1,0,1,2,-1,-4]

Sorted:

[-4,-1,-1,0,1,2]

Triplets:

[-1,-1,2]
[-1,0,1]
*/

import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        return ans;
    }
}
