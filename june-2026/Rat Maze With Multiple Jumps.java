// Rat Maze With Multiple Jumps

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] sol = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        if (solveMazeUtil(0, 0, mat, sol, visited, n)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sol[i][j]);
                }
                result.add(row);
            }
            return result;
        }

        ArrayList<ArrayList<Integer>> fallback = new ArrayList<>();
        ArrayList<Integer> errorRow = new ArrayList<>();
        errorRow.add(-1);
        fallback.add(errorRow);
        return fallback;
    }

    private boolean solveMazeUtil(int r, int c, int[][] mat, int[][] sol, boolean[][] visited, int n) {
        if (r == n - 1 && c == n - 1) {
            sol[r][c] = 1;
            return true;
        }

        if (isValid(r, c, n, mat) && !visited[r][c]) {
            sol[r][c] = 1;
            visited[r][c] = true;
            int maxJumps = mat[r][c];

            for (int jump = 1; jump <= maxJumps; jump++) {
                if (solveMazeUtil(r, c + jump, mat, sol, visited, n)) {
                    return true;
                }
                if (solveMazeUtil(r + jump, c, mat, sol, visited, n)) {
                    return true;
                }
            }

            sol[r][c] = 0;
            return false;
        }

        return false;
    }

    private boolean isValid(int r, int c, int n, int[][] mat) {
        return (r >= 0 && r < n && c >= 0 && c < n && mat[r][c] != 0);
    }
}