// LeetCode 75 - Sort Colors
// Topic: Two Pointers (Dutch National Flag Algorithm)
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

Maintain three pointers:

low  -> Next position for 0
mid  -> Current element
high -> Next position for 2

Rules:

1. nums[mid] == 0
   Swap with low.
   low++
   mid++

2. nums[mid] == 1
   Just move mid.

3. nums[mid] == 2
   Swap with high.
   high--
   Do NOT increment mid because the swapped element
   needs to be checked.

Example:

nums = [2,0,2,1,1,0]

low = 0
mid = 0
high = 5

Result:

[0,0,1,1,2,2]
*/

class Solution {

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
        }
