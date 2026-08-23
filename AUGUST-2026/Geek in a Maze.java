// Geek in a Maze

class Solution {
    
    // Helper class to store cell status in the priority queue
    static class Node implements Comparable<Node> {
        int r, c, u, d;
        
        Node(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }

        // Priority Queue orders by total vertical steps taken
        @Override
        public int compareTo(Node other) {
            return (this.u + this.d) - (other.u + other.d);
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Base case: If start cell is an obstacle
        if (mat[r][c] == '#') {
            return 0;
        }

        // Stores minimum upward and downward moves used to reach mat[i][j]
        int[][] minU = new int[n][m];
        int[][] minD = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(minU[i], Integer.MAX_VALUE);
            Arrays.fill(minD[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // Start position
        pq.add(new Node(r, c, 0, 0));
        minU[r][c] = 0;
        minD[r][c] = 0;

        int visitedCount = 0;
        boolean[][] visited = new boolean[n][m];

        // Direction arrays for Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // If cell is already processed with optimal steps, count it
            if (!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;
                visitedCount++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                // Check boundaries and obstacle
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] != '#') {
                    int newU = curr.u + (i == 0 ? 1 : 0); // Up move
                    int newD = curr.d + (i == 1 ? 1 : 0); // Down move

                    // Check if moves are within allowed bounds
                    if (newU <= u && newD <= d) {
                        // Relax edge if we found a path with strictly fewer vertical steps
                        if (newU < minU[nr][nc] || newD < minD[nr][nc]) {
                            minU[nr][nc] = Math.min(minU[nr][nc], newU);
                            minD[nr][nc] = Math.min(minD[nr][nc], newD);
                            pq.add(new Node(nr, nc, newU, newD));
                        }
                    }
                }
            }
        }

        return visitedCount;
    }
}