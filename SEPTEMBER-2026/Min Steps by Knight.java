// Min Steps by Knight

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int startX = knightPos[0];
        int startY = knightPos[1];
        int targetX = targetPos[0];
        int targetY = targetPos[1];

        if (startX == targetX && startY == targetY) {
            return 0;
        }

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == targetX && ny == targetY) {
                    return dist + 1;
                }

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}