// LeetCode 345 - Reverse Vowels of a String
// Topic: String + Two Pointers
// Difficulty: Easy
// Time Complexity: O(n)
// Space Complexity: O(1)

/*
Approach:

1. Convert the string into a character array.
2. Initialize two pointers:
      left = 0
      right = n - 1

3. Move left until a vowel is found.
4. Move right until a vowel is found.
5. Swap the two vowels.
6. Continue until left >= right.

Example:

Input:

s = "IceCreAm"

Vowels:

I, e, e, A

Output:

"AceCreIm"
*/

class Solution {

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && !isVowel(arr[left])) {
                left++;
            }

            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {

        ch = Character.toLowerCase(ch);

        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    }
}
