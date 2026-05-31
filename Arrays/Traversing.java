/*
=========================================
ARRAY TRAVERSAL
=========================================

Definition:
Traversal means visiting each element of an array exactly once
to perform some operation.

Time Complexity: O(n)
Space Complexity: O(1)

-----------------------------------------
1. FORWARD TRAVERSAL
-----------------------------------------
*/

public class Traversing {

    public static void forwardTraversal() {
        int[] arr = {10, 20, 30, 40, 50};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
    Output:
    10 20 30 40 50
    */

    /*
    -----------------------------------------
    2. REVERSE TRAVERSAL
    -----------------------------------------
    */

    public static void reverseTraversal() {
        int[] arr = {10, 20, 30, 40, 50};

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
    Output:
    50 40 30 20 10
    */

    /*
    -----------------------------------------
    3. ENHANCED FOR LOOP
    -----------------------------------------
    */

    public static void enhancedForLoop() {
        int[] arr = {10, 20, 30, 40, 50};

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /*
    Output:
    10 20 30 40 50
    */

    public static void main(String[] args) {
        forwardTraversal();
        System.out.println();

        reverseTraversal();
        System.out.println();

        enhancedForLoop();
    }
}
