// Max Subarray Sum by Removing At Most One

class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int maxEndHere = arr[0];
        int maxSkippedHere = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < n; i++) {
            int nextMaxSkipped = Math.max(maxEndHere, maxSkippedHere + arr[i]);
            int nextMaxEnd = Math.max(arr[i], maxEndHere + arr[i]);

            maxSkippedHere = nextMaxSkipped;
            maxEndHere = nextMaxEnd;

            overallMax = Math.max(overallMax, Math.max(maxEndHere, maxSkippedHere));
        }

        return overallMax;
    }
}