// Pyramid Array with Reduce Operations

class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // Left pass: calculate maximum height increasing from left
        left[0] = Math.min(arr[0], 1);
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        // Right pass: calculate maximum height increasing from right
        right[n - 1] = Math.min(arr[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long totalSum = 0;
        int maxPeak = 0;

        // Find the maximum valid peak height and calculate total array sum
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            int possiblePeak = Math.min(left[i], right[i]);
            maxPeak = Math.max(maxPeak, possiblePeak);
        }

        // Cost = (Total Sum of elements) - (Sum of the largest pyramid = maxPeak^2)
        long pyramidSum = (long) maxPeak * maxPeak;
        return (int) (totalSum - pyramidSum);
    }
}