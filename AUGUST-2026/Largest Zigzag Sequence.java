// Largest Zigzag Sequence

class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];

        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = -1, max2 = -1;
            int max1Col = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    max1Col = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] nextDp = new int[n];
            for (int j = 0; j < n; j++) {
                int prevMax = (j == max1Col) ? max2 : max1;
                nextDp[j] = mat[i][j] + prevMax;
            }
            dp = nextDp;
        }

        int maxResult = 0;
        for (int j = 0; j < n; j++) {
            maxResult = Math.max(maxResult, dp[j]);
        }

        return maxResult;
    }
}