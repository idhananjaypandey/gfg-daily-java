// Negative Weight Cycle

class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[0] = 0;

        // Relax edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                return true;
            }
        }

        return false;
    }
}