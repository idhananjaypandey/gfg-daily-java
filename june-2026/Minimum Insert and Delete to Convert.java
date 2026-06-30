// Minimum Insert and Delete to Convert

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            bMap.put(b[i], i);
        }

        List<Integer> transformedA = new ArrayList<>();
        for (int num : a) {
            if (bMap.containsKey(num)) {
                transformedA.add(bMap.get(num));
            }
        }

        int lcsLength = findLIS(transformedA);

        return (n - lcsLength) + (m - lcsLength);
    }

    private int findLIS(List<Integer> list) {
        if (list.isEmpty()) return 0;

        List<Integer> tails = new ArrayList<>();
        for (int num : list) {
            int idx = Collections.binarySearch(tails, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == tails.size()) {
                tails.add(num);
            } else {
                tails.set(idx, num);
            }
        }
        return tails.size();
    }
}