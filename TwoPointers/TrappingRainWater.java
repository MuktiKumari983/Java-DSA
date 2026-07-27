
// LeetCode 42 - Trapping Rain Water
// Topic: Two Pointers
// Difficulty: Hard
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach (Two Pointers):

Maintain two pointers:

left  -> Start of array
right -> End of array

Maintain:

leftMax  -> Maximum height seen from left
rightMax -> Maximum height seen from right

Rule:

If leftMax <= rightMax

    Water trapped at left

    = leftMax - height[left]

    Move left

Else

    Water trapped at right

    = rightMax - height[right]

    Move right

Example:

height = [0,1,0,2,1,0,1,3,2,1,2,1]

Water trapped = 6
*/

class Solution {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}
