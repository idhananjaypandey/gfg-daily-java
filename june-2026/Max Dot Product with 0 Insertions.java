// Max Dot Product with 0 Insertions

class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j > i) {
                    continue; 
                }

                int skipA = dp[i - 1][j];
                int matchBoth = dp[i - 1][j - 1] + (a[i - 1] * b[j - 1]);

                dp[i][j] = Math.max(skipA, matchBoth);
            }
        }

        return dp[n][m];
    }
}