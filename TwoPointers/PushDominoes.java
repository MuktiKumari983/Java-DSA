package ArraysAndStrings;

/**
 * Problem: LeetCode 838 - Push Dominoes
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        // Pad the string with dummy boundaries to handle edge cases cleanly
        String padded = "L" + dominoes + "R";
        StringBuilder result = new StringBuilder();
        int left = 0;

        for (int right = 1; right < padded.length(); right++) {
            if (padded.charAt(right) == '.') {
                continue;
            }

            // Calculate the number of unpushed dominoes between pointers
            int middleCount = right - left - 1;

            if (left > 0) {
                result.append(padded.charAt(left));
            }

            char leftChar = padded.charAt(left);
            char rightChar = padded.charAt(right);

            if (leftChar == rightChar) {
                // Case 1: Matching forces (R...R or L...L) -> All fall in same direction
                for (int i = 0; i < middleCount; i++) {
                    result.append(leftChar);
                }
            } else if (leftChar == 'R' && rightChar == 'L') {
                // Case 2: Opposite forces towards each other (R...L) -> Meet in middle
                for (int i = 0; i < middleCount / 2; i++) {
                    result.append('R');
                }
                if (middleCount % 2 == 1) {
                    result.append('.'); // Middle domino stays upright
                }
                for (int i = 0; i < middleCount / 2; i++) {
                    result.append('L');
                }
            } else {
                // Case 3: Forces directed away (L...R) -> Unaffected dots in middle
                for (int i = 0; i < middleCount; i++) {
                    result.append('.');
                }
            }

            left = right;
        }

        return result.toString();
    }

    // Driver code for quick testing
    public static void main(String[] args) {
        PushDominoes solution = new PushDominoes();

        String test1 = ".L.R...LR..L..";
        String test2 = "RR.L";

        System.out.println("Input:  " + test1);
        System.out.println("Output: " + solution.pushDominoes(test1)); 
        // Expected: "LL.RR.LLRRLL.."

        System.out.println("\nInput:  " + test2);
        System.out.println("Output: " + solution.pushDominoes(test2)); 
        // Expected: "RR.L"
    }
}
