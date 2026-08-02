// LeetCode 344 - Reverse String
// Topic: Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

Use two pointers:

left  -> Beginning of the array
right -> End of the array

Swap the characters at both pointers.

Move:
left++
right--

Continue until left >= right.

Example:

Input:

['h','e','l','l','o']

Swap:

h <-> o

e <-> l

Result:

['o','l','l','e','h']
*/

class Solution {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
