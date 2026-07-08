// Towers Reaching Both Stations

class Solution {
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] reachP = new boolean[n][m];
        boolean[][] reachQ = new boolean[n][m];

        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            reachP[i][0] = true;
            queueP.offer(new int[]{i, 0});
            
            reachQ[i][m - 1] = true;
            queueQ.offer(new int[]{i, m - 1});
        }

        for (int j = 0; j < m; j++) {
            reachP[0][j] = true;
            queueP.offer(new int[]{0, j});
            
            reachQ[n - 1][j] = true;
            queueQ.offer(new int[]{n - 1, j});
        }

        bfs(mat, queueP, reachP, n, m);
        bfs(mat, queueQ, reachQ, n, m);

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (reachP[i][j] && reachQ[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int[][] mat, Queue<int[]> queue, boolean[][] reach, int n, int m) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !reach[nr][nc]) {
                    if (mat[nr][nc] >= mat[r][c]) {
                        reach[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}