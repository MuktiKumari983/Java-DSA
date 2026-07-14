// LeetCode 283 - Move Zeroes
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Use two pointers:
   - i points to the position where the next non-zero
     element should be placed.
   - j scans the array.

2. If nums[j] is non-zero:
   - Swap nums[i] and nums[j].
   - Move i forward.

3. If nums[j] is zero:
   - Continue scanning.

This keeps all non-zero elements in their original order
while moving all zeros to the end.

Example:

nums = [0,1,0,3,12]

i = 0

j = 0 -> Zero
j = 1 -> Swap(0,1)
[1,0,0,3,12]

j = 2 -> Zero

j = 3 -> Swap(1,3)
[1,3,0,0,12]

j = 4 -> Swap(2,4)
[1,3,12,0,0]

Answer:
[1,3,12,0,0]
*/

class Solution {

    public void moveZeroes(int[] nums) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }
}
