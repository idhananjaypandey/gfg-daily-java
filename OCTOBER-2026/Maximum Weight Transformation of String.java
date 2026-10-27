// Maximum Weight Transformation of String

class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i >= 2) {
                int cost = s.charAt(i - 2) == s.charAt(i - 1) ? 1 : 0;
                dp[i] = Math.max(dp[i], dp[i - 2] + 4 - cost);
            }
        }

        return dp[n];
    }
}