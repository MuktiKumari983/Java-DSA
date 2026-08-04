// LeetCode 643 - Maximum Average Subarray I
// Topic: Sliding Window
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

We need the maximum average of any subarray of size k.

Instead of calculating the sum of every window again,
maintain a fixed-size sliding window.

Steps:

1. Calculate the sum of the first k elements.
2. Store it as the current maximum sum.
3. Slide the window one element at a time:
      - Remove the leftmost element.
      - Add the new rightmost element.
4. Update the maximum sum.
5. Return maxSum / k.

Example:

nums = [1,12,-5,-6,50,3]
k = 4

First window:
[1,12,-5,-6]
Sum = 2

Slide →

[12,-5,-6,50]
Sum = 51

Slide →

[-5,-6,50,3]
Sum = 42

Maximum Sum = 51

Average = 51 / 4 = 12.75
*/

class Solution {

    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {

            sum = sum - nums[i - k] + nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
