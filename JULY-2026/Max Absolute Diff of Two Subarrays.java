// Max Absolute Diff of Two Subarrays

class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        int[] maxLeft = new int[n];
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];
        int[] minRight = new int[n];

        int currentMax = arr[0];
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxLeft[i] = Math.max(maxLeft[i - 1], currentMax);
        }

        int currentMin = arr[0];
        minLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minLeft[i] = Math.min(minLeft[i - 1], currentMin);
        }

        currentMax = arr[n - 1];
        maxRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxRight[i] = Math.max(maxRight[i + 1], currentMax);
        }

        currentMin = arr[n - 1];
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minRight[i] = Math.min(minRight[i + 1], currentMin);
        }

        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int option1 = Math.abs(maxLeft[i] - minRight[i + 1]);
            int option2 = Math.abs(minLeft[i] - maxRight[i + 1]);
            maxDiff = Math.max(maxDiff, Math.max(option1, option2));
        }

        return maxDiff;
    }
}