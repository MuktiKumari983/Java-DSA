import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {

        int n = nums.length;

        // dp[i] = maximum sum of a valid subsequence
        // ending at index i
        int[] dp = new int[n];

        // Stores indices of dp values in decreasing order
        Deque<Integer> deque = new ArrayDeque<>();

        int answer = nums[0];

        for (int i = 0; i < n; i++) {

            // Remove indices that are outside the allowed range
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // Best previous dp value within distance k
            int bestPrevious = deque.isEmpty() ? 0 : dp[deque.peekFirst()];

            // Either start a new subsequence at i
            // or extend the best previous subsequence
            dp[i] = nums[i] + Math.max(0, bestPrevious);

            answer = Math.max(answer, dp[i]);

            // Maintain decreasing dp values
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return answer;
    }
}
