class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // code here
        if (u == v) {
            return true;
        }
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[u] = true;
        queue.offer(u);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == v) {
                return true;
            }
            for (int next : adj.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}