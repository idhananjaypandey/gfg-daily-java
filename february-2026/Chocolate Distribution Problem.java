import java.util.*;

class Solution {
    public long findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        
        if (m == 0 || n == 0) return 0;
        
        Collections.sort(arr);
        
        if (n < m) return -1;
        
        long minDiff = Long.MAX_VALUE;
        
        for (int i = 0; i + m - 1 < n; i++) {
            long currentDiff = (long)arr.get(i + m - 1) - arr.get(i);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }
        
        return minDiff;
    }
}