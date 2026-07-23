// LeetCode 948 - Bag of Tokens
// Topic: Greedy + Two Pointers
// Difficulty: Medium
// Time Complexity: O(n log n)
// Space Complexity: O(1) (excluding sorting)

/*
Approach:

1. Sort the tokens.
2. Use two pointers:
      left  -> Smallest token
      right -> Largest token

3. If we have enough power:
      Play the smallest token face up.
      Power decreases.
      Score increases.
      Move left.

4. Otherwise, if score > 0:
      Play the largest token face down.
      Gain power.
      Lose one score.
      Move right.

5. Keep track of the maximum score obtained.

Example:

tokens = [100,200,300,400]
power = 200

Play 100 face up
Power = 100
Score = 1

Play 400 face down
Power = 500
Score = 0

Play 200 face up
Power = 300
Score = 1

Play 300 face up
Power = 0
Score = 2

Answer = 2
*/

import java.util.Arrays;

class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while (left <= right) {

            if (power >= tokens[left]) {

                power -= tokens[left];
                score++;
                maxScore = Math.max(maxScore, score);
                left++;

            } else if (score > 0) {

                power += tokens[right];
                score--;
                right--;

            } else {

                break;
            }
        }

        return maxScore;
    }
                }
