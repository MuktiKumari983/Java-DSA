// LeetCode 977 - Squares of a Sorted Array
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(n)

/*
Approach:

1. Since the array is sorted, the largest square
   will come from either the leftmost negative
   number or the rightmost positive number.

2. Use two pointers:
   - left at the beginning
   - right at the end

3. Compare the absolute values.

4. Place the larger square at the end of
   the answer array.

5. Move the corresponding pointer.

Example:

nums = [-7,-3,2,3,11]

Compare:

|-7| vs |11|

121 is larger

Place 121 at the end.

Continue...

Output:

[4,9,9,49,121]
*/

class Solution {

    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {

                answer[index] = nums[left] * nums[left];
                left++;

            } else {

                answer[index] = nums[right] * nums[right];
                right--;
            }

            index--;
        }

        return answer;
    }
}
