// LeetCode 238 - Product of Array Except Self
// Topic: Prefix Product, Suffix Product
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding output array)

/*
Approach:

1. Store prefix products in the answer array.
2. answer[i] contains the product of all elements
   to the left of index i.
3. Traverse from right to left maintaining a
   suffix product.
4. Multiply answer[i] by the current suffix.
5. The final answer contains the product of all
   elements except itself.

Example:

nums = [1,2,3,4]

Prefix:
[1,1,2,6]

Suffix traversal:
answer = [24,12,8,6]

Output:
[24,12,8,6]
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n];

        arr[0] = 1;

        for (int i = 1; i < n; i++) {

            arr[i] = arr[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            arr[i] = arr[i] * suffix;

            suffix = suffix * nums[i];
        }

        return arr;
    }
}
