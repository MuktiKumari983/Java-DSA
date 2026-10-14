import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            // If the number is already present,
            // we have found a duplicate.
            if (set.contains(num)) {
                return true;
            }

            // Store the number for future checks.
            set.add(num);
        }

        return false;
    }
}
