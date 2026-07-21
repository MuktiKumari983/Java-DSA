// LeetCode 350 - Intersection of Two Arrays II
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n log n + m log m)
// Space Complexity: O(min(n, m)) (excluding sorting)

/*
Approach:

1. Sort both arrays.
2. Initialize two pointers:
      i -> nums1
      j -> nums2

3. If nums1[i] == nums2[j]:
      Add the element to the answer.
      Move both pointers.

4. If nums1[i] < nums2[j]:
      Move i.

5. Otherwise:
      Move j.

Example:

nums1 = [1,2,2,1]
nums2 = [2,2]

Sorted:

nums1 = [1,1,2,2]
nums2 = [2,2]

Answer:

[2,2]
*/

import java.util.*;

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {

                list.add(nums1[i]);
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {

                i++;

            } else {

                j++;
            }
        }

        int[] ans = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }

        return ans;
    }
}
