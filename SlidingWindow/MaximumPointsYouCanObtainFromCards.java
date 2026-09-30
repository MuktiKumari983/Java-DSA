class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // We can take k cards from the ends,
        // so n-k cards will remain in the middle.
        int windowSize = n - k;

        // Find the sum of the first window
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        // Find the minimum sum of a window of size n-k
        for (int right = windowSize; right < n; right++) {

            windowSum += cardPoints[right];
            windowSum -= cardPoints[right - windowSize];

            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        // Total sum - minimum middle window
        return getTotalSum(cardPoints) - minWindowSum;
    }

    private int getTotalSum(int[] cardPoints) {
        int total = 0;

        for (int points : cardPoints) {
            total += points;
        }

        return total;
    }
}
