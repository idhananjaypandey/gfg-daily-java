class Solution {
    class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    class Query implements Comparable<Query> {
        int limit, index;
        Query(int limit, int index) {
            this.limit = limit;
            this.index = index;
        }
        public int compareTo(Query other) {
            return Integer.compare(this.limit, other.limit);
        }
    }

    int[] parent;
    int[] size;

    int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edgesArray, int[] queriesArray) {
        Edge[] edges = new Edge[n - 1];
        for (int i = 0; i < n - 1; i++) {
            edges[i] = new Edge(edgesArray[i][0], edgesArray[i][1], edgesArray[i][2]);
        }
        Arrays.sort(edges);

        int qCount = queriesArray.length;
        Query[] queries = new Query[qCount];
        for (int i = 0; i < qCount; i++) {
            queries[i] = new Query(queriesArray[i], i);
        }
        Arrays.sort(queries);

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int edgeIdx = 0;
        long currentPaths = 0;
        int[] ans = new int[qCount];

        for (int i = 0; i < qCount; i++) {
            while (edgeIdx < n - 1 && edges[edgeIdx].w <= queries[i].limit) {
                int rootU = find(edges[edgeIdx].u);
                int rootV = find(edges[edgeIdx].v);
                if (rootU != rootV) {
                    currentPaths += (long) size[rootU] * size[rootV];
                    parent[rootU] = rootV;
                    size[rootV] += size[rootU];
                }
                edgeIdx++;
            }
            ans[queries[i].index] = (int) currentPaths;
        }

        ArrayList<Integer> result = new ArrayList<>(qCount);
        for (int i = 0; i < qCount; i++) {
            result.add(ans[i]);
        }
        return result;
    }
}