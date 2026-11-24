class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        Map<Integer, int[]> map = new HashMap<>();
        int[] best = null;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new int[]{i, j});
                } else {
                    int[] prev = map.get(sum);
                    int a = prev[0], b = prev[1];
                    if (a != i && a != j && b != i && b != j) {
                        int[] cand = new int[]{a, b, i, j};
                        if (best == null || isSmaller(cand, best)) {
                            best = cand;
                        }
                    }
                }
            }
        }

        if (best == null) {
            return new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
        }
        return new ArrayList<>(Arrays.asList(best[0], best[1], best[2], best[3]));
    }

    private boolean isSmaller(int[] x, int[] y) {
        for (int k = 0; k < 4; k++) {
            if (x[k] != y[k]) {
                return x[k] < y[k];
            }
        }
        return false;
    }
}