// Mountain Subarray Queries

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1]) {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
        }

        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }

        ArrayList<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            if (right[l] >= left[r]) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}