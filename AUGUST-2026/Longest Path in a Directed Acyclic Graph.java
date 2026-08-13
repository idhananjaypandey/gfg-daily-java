// Longest Path in a Directed Acyclic Graph

class Solution {
    static class Pair {
        int v, w;
        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack, adj);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != Integer.MIN_VALUE) {
                for (Pair neighbor : adj.get(u)) {
                    if (dist[u] + neighbor.w > dist[neighbor.v]) {
                        dist[neighbor.v] = dist[u] + neighbor.w;
                    }
                }
            }
        }

        return dist;
    }

    private void topoSort(int u, boolean[] visited, Stack<Integer> stack, List<List<Pair>> adj) {
        visited[u] = true;
        for (Pair neighbor : adj.get(u)) {
            if (!visited[neighbor.v]) {
                topoSort(neighbor.v, visited, stack, adj);
            }
        }
        stack.push(u);
    }
}
