class Solution {
    public int minTime(int n, int s1, int s2) {
        long low = 1;
        long high = (long) Math.min(s1, s2) * n;
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long docs = (mid / s1) + (mid / s2);
            
            if (docs >= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return (int) ans;
    }
}