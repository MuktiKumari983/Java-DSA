// LeetCode 904 - Fruit Into Baskets
// Topic: Sliding Window
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

We can carry only two types of fruit.

So we maintain a sliding window containing
at most two different fruit types.

Use a HashMap:

key   -> fruit type
value -> frequency of that fruit in the window

Steps:

1. Expand the window using the right pointer.
2. Add the current fruit to the map.
3. If the window contains more than two fruit types:
      - Remove fruits from the left.
      - Decrease their frequency.
      - Remove a fruit type when its frequency becomes 0.
4. Update the maximum window length.

Example:

fruits = [1,2,1]

Window:

[1]       -> 1 type
[1,2]     -> 2 types
[1,2,1]   -> 2 types

Maximum = 3

Example:

fruits = [1,2,3,2,2]

[1,2]       -> valid
[1,2,3]     -> 3 types -> shrink
[2,3]       -> valid
[2,3,2]     -> valid
[2,3,2,2]   -> valid

Answer = 4
*/

import java.util.HashMap;

class Solution {

    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(
                fruits[right],
                map.getOrDefault(fruits[right], 0) + 1
            );

            // More than two fruit types
            while (map.size() > 2) {

                map.put(
                    fruits[left],
                    map.get(fruits[left]) - 1
                );

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}
