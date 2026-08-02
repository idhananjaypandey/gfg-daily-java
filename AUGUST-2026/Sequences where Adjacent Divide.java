// Sequences where Adjacent Divide


class Solution {
    public int count(int n, int m) {
        // dp[i][j] stores the number of sequences of length i ending with value j
        int[][] dp = new int[n + 1][m + 1];
        
        // Base case: arrays of length 1 ending in any number from 1 to m
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }
        
        // Build DP table for lengths 2 to n
        for (int len = 2; len <= n; len++) {
            for (int curr = 1; curr <= m; curr++) {
                for (int prev = 1; prev <= m; prev++) {
                    // Check if one divides the other
                    if (curr % prev == 0 || prev % curr == 0) {
                        dp[len][curr] += dp[len - 1][prev];
                    }
                }
            }
        }
        
        // Total ways is the sum of valid sequences of length n
        int totalCount = 0;
        for (int j = 1; j <= m; j++) {
            totalCount += dp[n][j];
        }
        
        return totalCount;
    }
}