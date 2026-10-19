// Count Indices That Escape Array

class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int curr = i;
            java.util.ArrayList<Integer> path = new java.util.ArrayList<>();

            while (curr >= 0 && curr < n && state[curr] == 0) {
                state[curr] = 1;
                path.add(curr);
                curr += arr[curr];
            }

            boolean good;

            if (curr < 0 || curr >= n) {
                good = true;
            } else {
                good = state[curr] == 2;
            }

            for (int index : path) {
                state[index] = good ? 2 : 3;
            }
        }

        for (int s : state) {
            if (s == 2) {
                count++;
            }
        }

        return count;
    }
}