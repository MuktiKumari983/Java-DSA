// LeetCode 11 - Container With Most Water
// Topic: Two Pointers
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Initialize two pointers:
   - left = 0
   - right = n - 1

2. Calculate:
   width = right - left
   height = min(height[left], height[right])
   area = width * height

3. Update the maximum area.

4. Move the pointer with the smaller height
   because moving the taller one cannot increase
   the area while the width decreases.

Example:

height = [1,8,6,2,5,4,8,3,7]

left = 0
right = 8

Area = 8 × min(1,7) = 8

Move left because 1 < 7

Continue until left >= right.

Maximum Area = 49
*/

class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, width * currentHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
