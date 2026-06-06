// LeetCode 495 - Teemo Attacking
// Topic: Arrays, Interval Overlap
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:
1. Every attack contributes 'duration' seconds.
2. If the next attack occurs before the current poison ends,
   only add the gap between attacks.
3. Otherwise, add the full duration.
4. Finally, add the duration of the last attack.

Example:
timeSeries = [1,4], duration = 2

Attack at 1 -> poison [1,2]
Attack at 4 -> poison [4,5]

Total = 4
*/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {

            total += Math.min(duration,
                              timeSeries[i + 1] - timeSeries[i]);
        }

        return total + duration;
    }
}
