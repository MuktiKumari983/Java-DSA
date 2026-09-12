// LeetCode 1248 - Count Number of Nice Subarrays
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int left = 0;
        int oddCount = 0;
        int count = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {

            // Count odd numbers
            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            // Shrink if we have more than k odd numbers
            while (oddCount > k) {

                if (nums[left] % 2 == 1) {
                    oddCount--;
                }

                left++;
            }

            // Count valid subarrays
            count = 0;
            int temp = left;

            while (temp <= right && oddCount == k) {

                count++;

                if (nums[temp] % 2 == 1) {
                    break;
                }

                temp++;
            }

            result += count;
        }

        return result;
    }
}
