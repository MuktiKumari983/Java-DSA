// LeetCode 18 - 4Sum
// Topic: Two Pointers
// Difficulty: Medium
// Time Complexity: O(n³)
// Space Complexity: O(1) (excluding the output list)

/*
Approach:

1. Sort the array.
2. Fix the first element (i).
3. Fix the second element (j).
4. Use two pointers:
      left = j + 1
      right = n - 1
5. Find quadruplets whose sum equals target.
6. Skip duplicate values to avoid duplicate answers.

Example:

nums = [1,0,-1,0,-2,2]
target = 0

Sorted:

[-2,-1,0,0,1,2]

Answer:

[-2,-1,1,2]
[-2,0,0,2]
[-1,0,0,1]
*/

import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {

                        ans.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {

                        left++;

                    } else {

                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
