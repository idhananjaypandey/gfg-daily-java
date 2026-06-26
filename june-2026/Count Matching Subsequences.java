// Count Matching Subsequences

class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int MOD = 1000000007;

        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = m; j >= 1; j--) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }

        return dp[m];
    }
}