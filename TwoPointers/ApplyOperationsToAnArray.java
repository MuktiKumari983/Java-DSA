// LeetCode 2460 - Apply Operations to an Array
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

Step 1:
Traverse the array.

If two adjacent elements are equal:
    nums[i] = nums[i] * 2
    nums[i + 1] = 0

Step 2:
Move all non-zero elements to the front
using the Two Pointer technique.

Example:

Input:
[1,2,2,1,1,0]

After Step 1:
[1,4,0,2,0,0]

After Step 2:
[1,4,2,0,0,0]

Output:
[1,4,2,0,0,0]
*/

class Solution {

    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        // Apply operations
        for (int i = 0; i < n - 1; i++) {

            if (nums[i] == nums[i + 1]) {

                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Move all non-zero elements to the front
        int j = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }

        return nums;
    }
}
