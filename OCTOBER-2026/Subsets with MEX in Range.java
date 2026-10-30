class Solution {
    public int cntSubsets(int[] arr, int l, int r) {
        long MOD = 1000000007;
        int n = arr.length;
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        
        int maxVal = Math.max(r + 2, n + 2);
        int[] suffixSum = new int[maxVal];
        for (int i = maxVal - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + freq.getOrDefault(i, 0);
        }
        
        long totalSubsets = 0;
        long prefixProduct = 1;
        
        for (int M = 0; M <= r; M++) {
            int countM = freq.getOrDefault(M, 0);
            
            if (M >= l) {
                long elementsGreaterThanM = suffixSum[M + 1];
                long waysGreater = pow2[(int) elementsGreaterThanM];
                long currentWays = (prefixProduct * waysGreater) % MOD;
                totalSubsets = (totalSubsets + currentWays) % MOD;
            }
            
            if (countM == 0) {
                break;
            }
            
            long waysForM = (pow2[countM] - 1 + MOD) % MOD;
            prefixProduct = (prefixProduct * waysForM) % MOD;
        }
        
        return (int) totalSubsets;
    }
}