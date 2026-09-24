// Maximum Height Disc Stack

class Solution {
    class Disc {
        int r, h;
        Disc(int r, int h) {
            this.r = r;
            this.h = h;
        }
    }

    class SegmentTree {
        int size;
        int[] tree;

        SegmentTree(int size) {
            this.size = size;
            tree = new int[4 * size + 1];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = Math.max(tree[node], val);
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        int query(int node, int start, int end, int l, int r) {
            if (l > end || r < start || l > r) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node, start, mid, l, r);
            int p2 = query(2 * node + 1, mid + 1, end, l, r);
            return Math.max(p1, p2);
        }
    }

    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        Disc[] discs = new Disc[n];
        for (int i = 0; i < n; i++) {
            discs[i] = new Disc(r[i], h[i]);
        }

        Arrays.sort(discs, (a, b) -> {
            if (a.r != b.r) {
                return Integer.compare(a.r, b.r);
            }
            return Integer.compare(a.h, b.h);
        });

        TreeSet<Integer> uniqueHeights = new TreeSet<>();
        for (int height : h) {
            uniqueHeights.add(height);
        }

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int height : uniqueHeights) {
            rankMap.put(height, rank++);
        }

        int maxVal = rankMap.size();
        SegmentTree st = new SegmentTree(maxVal);

        int maxTotalHeight = 0;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && discs[j].r == discs[i].r) {
                j++;
            }

            List<int[]> updates = new ArrayList<>();
            for (int k = i; k < j; k++) {
                int hRank = rankMap.get(discs[k].h);
                int bestPrevious = st.query(1, 1, maxVal, 1, hRank - 1);
                int currentMax = bestPrevious + discs[k].h;
                updates.add(new int[]{hRank, currentMax});
                maxTotalHeight = Math.max(maxTotalHeight, currentMax);
            }

            for (int[] update : updates) {
                st.update(1, 1, maxVal, update[0], update[1]);
            }

            i = j;
        }

        return maxTotalHeight;
    }
}