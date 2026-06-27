// Ways to Tile the Floor

class Solution {
    public int countWays(int n, int m) {
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }

        int mod = 1000000007;
        int[] dp = new int[n + 1];

        for (int i = 1; i < m; i++) {
            dp[i] = 1;
        }
        dp[m] = 2;

        for (int i = m + 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - m]) % mod;
        }

        return dp[n];
    }
}