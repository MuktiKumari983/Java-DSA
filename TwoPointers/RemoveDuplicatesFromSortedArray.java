// LeetCode 26 - Remove Duplicates from Sorted Array
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Use two pointers:
   - i keeps track of the last unique element.
   - j scans the array.

2. If nums[j] is different from nums[i]:
   - Move i one step forward.
   - Copy nums[j] to nums[i].

3. If nums[j] is the same:
   - Skip it by moving j.

4. Return the number of unique elements (i + 1).

Example:

nums = [1,1,2,2,3]

Initially:
i = 0, j = 1

1 == 1 → Move j

2 != 1
Move i
Copy 2

Array becomes:
[1,2,2,2,3]

Continue...

Final:
[1,2,3,_,_]

Return 3
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;

        while (j < nums.length) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }
}
