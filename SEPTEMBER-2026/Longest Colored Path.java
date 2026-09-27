// Longest Colored Path

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] parent = new int[n];
        int[] order = new int[n];
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int head = 0, tail = 0, idx = 0;

        queue[tail++] = 0;
        visited[0] = true;
        parent[0] = -1;

        while (head < tail) {
            int u = queue[head++];
            order[idx++] = u;
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue[tail++] = v;
                }
            }
        }

        int[] allRed = new int[n];
        int[] allBlue = new int[n];
        int[] down = new int[n];
        int[] down2 = new int[n];
        int NEG = Integer.MIN_VALUE / 2;
        int ans = 1;

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            char c = s.charAt(u);
            List<Integer> children = new ArrayList<>();
            for (int v : adj.get(u)) if (v != parent[u]) children.add(v);

            if (c == 'R') {
                int val = 1;
                for (int ch : children) val = Math.max(val, 1 + allRed[ch]);
                allRed[u] = val;
                allBlue[u] = 0;
            } else {
                int val = 1;
                for (int ch : children) val = Math.max(val, 1 + allBlue[ch]);
                allBlue[u] = val;
                allRed[u] = 0;
            }

            if (c == 'R') {
                int val = 1;
                for (int ch : children) val = Math.max(val, 1 + down[ch]);
                down[u] = val;
                int val2 = 1;
                for (int ch : children) val2 = Math.max(val2, 1 + allRed[ch]);
                down2[u] = val2;
            } else {
                int val = 1;
                for (int ch : children) val = Math.max(val, 1 + allBlue[ch]);
                down[u] = val;
                int val2 = 1;
                for (int ch : children) val2 = Math.max(val2, 1 + down2[ch]);
                down2[u] = val2;
            }

            int[] leftArr = (c == 'R') ? allRed : down2;
            int[] rightArr = (c == 'R') ? down : allBlue;

            int t1lVal = NEG, t1lIdx = -1, t2lVal = NEG, t2lIdx = -1;
            int t1rVal = NEG, t1rIdx = -1, t2rVal = NEG, t2rIdx = -1;

            for (int ch : children) {
                int lv = leftArr[ch];
                if (lv > t1lVal) { t2lVal = t1lVal; t2lIdx = t1lIdx; t1lVal = lv; t1lIdx = ch; }
                else if (lv > t2lVal) { t2lVal = lv; t2lIdx = ch; }

                int rv = rightArr[ch];
                if (rv > t1rVal) { t2rVal = t1rVal; t2rIdx = t1rIdx; t1rVal = rv; t1rIdx = ch; }
                else if (rv > t2rVal) { t2rVal = rv; t2rIdx = ch; }
            }

            int best = NEG;
            if (t1lIdx != -1 && t1rIdx != -1) {
                if (t1lIdx != t1rIdx) {
                    best = t1lVal + t1rVal;
                } else {
                    if (t2lIdx != -1) best = Math.max(best, t2lVal + t1rVal);
                    if (t2rIdx != -1) best = Math.max(best, t1lVal + t2rVal);
                }
            }
            int comboVal = (best == NEG) ? NEG : 1 + best;

            ans = Math.max(ans, down[u]);
            ans = Math.max(ans, down2[u]);
            if (comboVal != NEG) ans = Math.max(ans, comboVal);
        }

        return ans;
    }
}