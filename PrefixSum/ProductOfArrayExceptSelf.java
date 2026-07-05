// LeetCode 238 - Product of Array Except Self
// Topic: Prefix Product, Suffix Product
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding the output array)

/*
Approach:

1. Store prefix products in the answer array.
2. answer[i] contains the product of all elements
   to the left of index i.
3. Traverse from right to left while maintaining
   a suffix product.
4. Multiply the prefix product by the suffix product.
5. Return the answer array.

Example:

Input:
nums = [1,2,3,4]

Prefix Products:
[1,1,2,6]

Suffix Traversal:

i = 3 -> answer[3] = 6
i = 2 -> answer[2] = 8
i = 1 -> answer[1] = 12
i = 0 -> answer[0] = 24

Output:
[24,12,8,6]
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        // Prefix products
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}
