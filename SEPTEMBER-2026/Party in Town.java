// Party in Town

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int maxDistFromFarNode = 0;
        
        int startNode = 1;
        int nodeA = getFarthestNode(startNode, adj, n)[0];
        
        int[] resultB = getFarthestNode(nodeA, adj, n);
        maxDistFromFarNode = resultB[1];
        
        return (maxDistFromFarNode + 1) / 2;
    }

    private int[] getFarthestNode(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (dist[curr] > maxDist) {
                maxDist = dist[curr];
                farthestNode = curr;
            }

            for (int neighbor : adj.get(curr - 1)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[curr] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}