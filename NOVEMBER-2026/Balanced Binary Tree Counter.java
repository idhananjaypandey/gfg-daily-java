class Solution {
    public int countBT(int h) {
        if (h <= 0) return 0;
        long MOD = 1000000007;
        long[] dp = new long[h + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= h; i++) {
            long prev1 = dp[i - 1];
            long prev2 = dp[i - 2];
            dp[i] = (prev1 * prev1 % MOD + 2 * prev1 * prev2 % MOD) % MOD;
        }
        return (int) dp[h];
    }
}