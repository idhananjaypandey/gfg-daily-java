// Range GCD Queries

class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void buildTree(int node, int start, int end, int[] arr, int[] tree) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(2 * node + 1, start, mid, arr, tree);
        buildTree(2 * node + 2, mid + 1, end, arr, tree);
        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private void updateTree(int node, int start, int end, int idx, int val, int[] tree) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            updateTree(2 * node + 1, start, mid, idx, val, tree);
        } else {
            updateTree(2 * node + 2, mid + 1, end, idx, val, tree);
        }
        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private int queryTree(int node, int start, int end, int l, int r, int[] tree) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftGcd = queryTree(2 * node + 1, start, mid, l, r, tree);
        int rightGcd = queryTree(2 * node + 2, mid + 1, end, l, r, tree);
        return gcd(leftGcd, rightGcd);
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] tree = new int[4 * n];
        buildTree(0, 0, n - 1, arr, tree);

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 0) {
                int l = q[1];
                int r = q[2];
                result.add(queryTree(0, 0, n - 1, l, r, tree));
            } else if (type == 1) {
                int idx = q[1];
                int val = q[2];
                updateTree(0, 0, n - 1, idx, val, tree);
            }
        }

        return result;
    }
}