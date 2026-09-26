// Minimum Cost Pizza Selection

class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int maxArea = x + l;
        int[] dp = new int[maxArea + 1];
        
        for (int i = 1; i <= maxArea; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            if (i >= s && dp[i - s] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - s] + cs);
            } else if (i < s) {
                dp[i] = Math.min(dp[i], cs);
            }
            
            if (i >= m && dp[i - m] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - m] + cm);
            } else if (i < m) {
                dp[i] = Math.min(dp[i], cm);
            }
            
            if (i >= l && dp[i - l] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - l] + cl);
            } else if (i < l) {
                dp[i] = Math.min(dp[i], cl);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = x; i <= maxArea; i++) {
            ans = Math.min(ans, dp[i]);
        }
        
        return ans;
    }
}