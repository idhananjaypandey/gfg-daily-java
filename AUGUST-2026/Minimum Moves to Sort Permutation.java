// Minimum Moves to Sort Permutation

class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        int maxLen = 0;

        for (int num : arr) {
            dp[num] = dp[num - 1] + 1;
            maxLen = Math.max(maxLen, dp[num]);
        }

        return n - maxLen;
    }
}