// Adventure in a Maze

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;

        long[][] count = new long[n][n];
        int[][] maxSum = new int[n][n];

        // Base case: destination cell
        count[n - 1][n - 1] = 1;
        maxSum[n - 1][n - 1] = grid[n - 1][n - 1];

        // Fill the DP tables backwards from (n-1, n-1) to (0, 0)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Skip the destination cell as it is already initialized
                if (i == n - 1 && j == n - 1) continue;

                int val = grid[i][j];
                long totalWays = 0;
                int maxAdv = 0;

                // Check Right movement (Allowed if val == 1 or val == 3)
                if (val == 1 || val == 3) {
                    if (j + 1 < n && count[i][j + 1] > 0) {
                        totalWays = (totalWays + count[i][j + 1]) % MOD;
                        maxAdv = Math.max(maxAdv, maxSum[i][j + 1]);
                    }
                }

                // Check Down movement (Allowed if val == 2 or val == 3)
                if (val == 2 || val == 3) {
                    if (i + 1 < n && count[i + 1][j] > 0) {
                        totalWays = (totalWays + count[i + 1][j]) % MOD;
                        maxAdv = Math.max(maxAdv, maxSum[i + 1][j]);
                    }
                }

                // If at least one valid path exists to the destination from (i, j)
                if (totalWays > 0) {
                    count[i][j] = totalWays;
                    maxSum[i][j] = val + maxAdv;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) count[0][0]);
        result.add(maxSum[0][0]);

        return result;
    }
}