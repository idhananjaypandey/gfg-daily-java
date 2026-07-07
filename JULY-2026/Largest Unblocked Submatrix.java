// Largest Unblocked Submatrix

class Solution {
    public int largestArea(int n, int m, int k, int[][] arr) {
        if (k == 0) {
            return n * m;
        }

        int[] rows = new int[k + 2];
        int[] cols = new int[k + 2];

        rows[0] = 0;
        cols[0] = 0;
        rows[k + 1] = n + 1;
        cols[k + 1] = m + 1;

        for (int i = 0; i < k; i++) {
            rows[i + 1] = arr[i][0];
            cols[i + 1] = arr[i][1];
        }

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxRowGap = 0;
        for (int i = 1; i < rows.length; i++) {
            maxRowGap = Math.max(maxRowGap, rows[i] - rows[i - 1] - 1);
        }

        int maxColGap = 0;
        for (int i = 1; i < cols.length; i++) {
            maxColGap = Math.max(maxColGap, cols[i] - cols[i - 1] - 1);
        }

        return maxRowGap * maxColGap;
    }
}