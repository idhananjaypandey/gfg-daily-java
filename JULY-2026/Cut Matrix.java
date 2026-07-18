// Cut Matrix

class Solution {
    private static final int MOD = 1000000007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] count = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                count[i][j] = matrix[i][j] + count[i + 1][j] + count[i][j + 1] - count[i + 1][j + 1];
            }
        }

        if (count[0][0] < k) return 0;

        int[][] nextRow = new int[n][m];
        int[][] nextCol = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int i = r + 1;
                while (i < n && count[r][c] == count[i][c]) {
                    i++;
                }
                nextRow[r][c] = i;

                int j = c + 1;
                while (j < m && count[r][c] == count[r][j]) {
                    j++;
                }
                nextCol[r][c] = j;
            }
        }

        int[][][] dp = new int[k + 1][n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dp[1][r][c] = count[r][c] >= 1 ? 1 : 0;
            }
        }

        for (int p = 2; p <= k; p++) {
            int[][] sumRow = new int[n][m + 1];
            int[][] sumCol = new int[n + 1][m];

            for (int r = n - 1; r >= 0; r--) {
                for (int c = m - 1; c >= 0; c--) {
                    sumRow[r][c] = (sumRow[r][c + 1] + dp[p - 1][r][c]) % MOD;
                    sumCol[r][c] = (sumCol[r + 1][c] + dp[p - 1][r][c]) % MOD;
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (count[r][c] < p) continue;

                    long currentWays = 0;

                    int reqRow = nextRow[r][c];
                    if (reqRow < n) {
                        currentWays = (currentWays + sumCol[reqRow][c]) % MOD;
                    }

                    int reqCol = nextCol[r][c];
                    if (reqCol < m) {
                        currentWays = (currentWays + sumRow[r][reqCol]) % MOD;
                    }

                    dp[p][r][c] = (int) currentWays;
                }
            }
        }

        return dp[k][0][0];
    }
}