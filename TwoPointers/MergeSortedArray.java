// LeetCode 88 - Merge Sorted Array
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(m + n)
// Space Complexity: O(1)

/*
Approach:

nums1 has enough extra space at the end to hold all elements.

Instead of merging from the front (which would overwrite
elements), merge from the back.

Pointers:

p1 -> Last valid element in nums1
p2 -> Last element in nums2
p  -> Last position in nums1

Algorithm:

1. Compare nums1[p1] and nums2[p2].
2. Place the larger element at nums1[p].
3. Move the corresponding pointer.
4. Continue until one array is exhausted.
5. If nums2 still has elements, copy them.

Example:

nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3

Start:

p1 = 2 (3)
p2 = 2 (6)
p  = 5

Result:

[1,2,2,3,5,6]
*/

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {

            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }

            p--;
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
