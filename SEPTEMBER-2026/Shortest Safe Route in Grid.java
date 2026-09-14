// Shortest Safe Route in Grid

class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = mat[i][j];
            }
        }
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    grid[i][j] = -1;
                    for (int k = 0; k < 4; k++) {
                        int r = i + dRow[k];
                        int c = j + dCol[k];
                        if (r >= 0 && r < n && c >= 0 && c < m) {
                            grid[r][c] = -1;
                        }
                    }
                }
            }
        }
        
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                q.add(new int[]{i, 0, 1});
                visited[i][0] = true;
            }
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            
            if (c == m - 1) {
                return dist;
            }
            
            for (int k = 0; k < 4; k++) {
                int nr = r + dRow[k];
                int nc = c + dCol[k];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, dist + 1});
                }
            }
        }
        
        return -1;
    }
}