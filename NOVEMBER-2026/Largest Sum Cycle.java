class Solution {
    public int largestSumCycle(int edge[]) {
        int n = edge.length;

        int[] visited = new int[n];
        int[] pathId = new int[n];

        int maxSum = -1;
        int currentPath = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }

            currentPath++;
            int node = i;

            while (node != -1 && visited[node] == 0) {
                visited[node] = 1;
                pathId[node] = currentPath;
                node = edge[node];
            }

            if (node != -1 && pathId[node] == currentPath) {
                int sum = 0;
                int current = node;

                do {
                    sum += current;
                    current = edge[current];
                } while (current != node);

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
