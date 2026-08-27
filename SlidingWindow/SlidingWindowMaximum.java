// LeetCode 239 - Sliding Window Maximum
// Topic: Sliding Window
// Difficulty: Hard
// Pattern: Monotonic Deque
// Time Complexity: O(n)
// Space Complexity: O(k)

import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int right = 0; right < n; right++) {

            // Remove elements that are outside the window
            while (!deque.isEmpty()
                    && deque.peekFirst() <= right - k) {

                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[right]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Window is ready
            if (right >= k - 1) {

                ans[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return ans;
    }
}
