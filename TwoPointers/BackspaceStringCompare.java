// LeetCode 844 - Backspace String Compare
// Topic: String + Two Pointers
// Difficulty: Easy
// Time Complexity: O(n + m)
// Space Complexity: O(1)

/*
Approach:

Traverse both strings from right to left.

Maintain:

i -> Last character of s
j -> Last character of t

Use skip counters:

skipS -> Number of backspaces in s
skipT -> Number of backspaces in t

Skip characters deleted by '#'.

Compare the valid characters.

If they differ, return false.

If traversal finishes successfully, return true.

Example:

s = "ab#c"

t = "ad#c"

After processing:

s = "ac"

t = "ac"

Answer = true
*/

class Solution {

    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {

                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {

                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {

                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }

            } else if (i >= 0 || j >= 0) {

                return false;
            }

            i--;
            j--;
        }

        return true;
    }
        }
