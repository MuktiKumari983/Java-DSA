// LeetCode 303 - Range Sum Query - Immutable
// Topic: Prefix Sum
// Difficulty: Easy
// Time Complexity:
// Constructor: O(n)
// sumRange(): O(1)
// Space Complexity: O(n)

/*
Approach:

1. Build a prefix sum array.
2. prefix[i] stores the sum of elements
   from index 0 to i.
3. To answer a query:
   - If left == 0:
       answer = prefix[right]
   - Otherwise:
       answer = prefix[right] - prefix[left - 1]

Example:

nums = [-2,0,3,-5,2,-1]

Prefix:
[-2,-2,1,-4,-2,-3]

Query:
sumRange(2,5)

Answer:
prefix[5] - prefix[1]
= -3 - (-2)
= -1
*/

class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {

        prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            prefix[i] = nums[i] + prefix[i - 1];
        }
    }

    public int sumRange(int left, int right) {

        if (left == 0) {
            return prefix[right];
        }

        return prefix[right] - prefix[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left, right);
 */
