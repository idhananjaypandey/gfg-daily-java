// Minimize Max Min Diff with Subarray Removal

class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        if (k >= n) return 0;
        
        int[] prefixMin = new int[n];
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] suffixMax = new int[n];
        
        prefixMin[0] = arr[0];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        
        suffixMin[n - 1] = arr[n - 1];
        suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n - k; i++) {
            int left = i - 1;
            int right = i + k;
            
            int curMin = Integer.MAX_VALUE;
            int curMax = Integer.MIN_VALUE;
            
            if (left >= 0) {
                curMin = Math.min(curMin, prefixMin[left]);
                curMax = Math.max(curMax, prefixMax[left]);
            }
            
            if (right < n) {
                curMin = Math.min(curMin, suffixMin[right]);
                curMax = Math.max(curMax, suffixMax[right]);
            }
            
            minDiff = Math.min(minDiff, curMax - curMin);
        }
        
        return minDiff;
    }
}