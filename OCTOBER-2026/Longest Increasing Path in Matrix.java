// Longest Increasing Path in Matrix

class Solution {
    private int[][] memo;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int longIncPath(int[][] matrix, int n, int m) {
        if (matrix == null || n == 0 || m == 0) {
            return 0;
        }

        memo = new int[n][m];
        int maxPath = 0;

        // Try starting the path from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, n, m));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m) {
        // Return stored result if already calculated
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxLength = 1; // Base path length is 1 (the cell itself)

        // Explore all 4 possible directions (Up, Down, Left, Right)
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            // Check boundaries and strictly increasing condition
            if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newX, newY, n, m));
            }
        }

        // Cache and return the result
        return memo[i][j] = maxLength;
    }
}