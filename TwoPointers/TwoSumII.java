// LeetCode 167 - Two Sum II - Input Array Is Sorted
// Topic: Two Pointers
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Initialize two pointers:
   - left = 0
   - right = n - 1

2. Calculate the sum of the two elements.

3. If sum == target:
      return their 1-based indices.

4. If sum < target:
      Move the left pointer to increase the sum.

5. If sum > target:
      Move the right pointer to decrease the sum.

Since the array is sorted,
we can eliminate one element in every step.

Example:

numbers = [2,7,11,15]
target = 9

left = 2
right = 15

2 + 15 > 9 → Move right

2 + 11 > 9 → Move right

2 + 7 = 9

Answer = [1,2]
*/

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
