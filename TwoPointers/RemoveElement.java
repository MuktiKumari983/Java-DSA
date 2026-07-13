// LeetCode 27 - Remove Element
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Use two pointers:
   - i points to the position where the next valid element
     should be placed.
   - j traverses the entire array.

2. If nums[j] is not equal to val:
   - Copy nums[j] to nums[i].
   - Increment i.

3. If nums[j] equals val:
   - Skip it.

4. Return i, which represents the number of remaining elements.

Example:

nums = [3,2,2,3]
val = 3

Initially:
i = 0
j = 0

3 == val
Skip

2 != val
nums[0] = 2
i++

2 != val
nums[1] = 2
i++

3 == val
Skip

Final array:
[2,2,_,_]

Return 2
*/

class Solution {

    public int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
