// Max After m Range Increments

class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        long[] diff = new long[n + 1];
        int m = a.length;

        for (int i = 0; i < m; i++) {
            int start = a[i];
            int end = b[i];
            int val = k[i];

            diff[start] += val;
            if (end + 1 < n) {
                diff[end + 1] -= val;
            }
        }

        long maxVal = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += diff[i];
            if (currentSum > maxVal) {
                maxVal = currentSum;
            }
        }

        return (int) maxVal;
    }
}