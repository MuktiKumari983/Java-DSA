// LeetCode 2024 - Maximize the Confusion of an Exam
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int maxLength = 0;

        // Try making all answers 'T'
        int left = 0;
        int falseCount = 0;

        for (int right = 0; right < answerKey.length(); right++) {

            if (answerKey.charAt(right) == 'F') {
                falseCount++;
            }

            while (falseCount > k) {
                if (answerKey.charAt(left) == 'F') {
                    falseCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Try making all answers 'F'
        left = 0;
        int trueCount = 0;

        for (int right = 0; right < answerKey.length(); right++) {

            if (answerKey.charAt(right) == 'T') {
                trueCount++;
            }

            while (trueCount > k) {
                if (answerKey.charAt(left) == 'T') {
                    trueCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
            }
