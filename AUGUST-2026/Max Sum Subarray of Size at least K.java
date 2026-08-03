// Max Sum Subarray of Size at least K

class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        int[] maxSum = new int[n];
        maxSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxSum[i] = Math.max(arr[i], maxSum[i - 1] + arr[i]);
        }

        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }

        int ans = curSum;
        for (int i = k; i < n; i++) {
            curSum = curSum + arr[i] - arr[i - k];
            ans = Math.max(ans, curSum);
            ans = Math.max(ans, curSum + maxSum[i - k]);
        }

        return ans;
    }
}