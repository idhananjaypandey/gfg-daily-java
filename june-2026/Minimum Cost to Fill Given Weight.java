// Minimum Cost to Fill Given Weight

class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];
        
        // Use a large value for infinity that won't cause integer overflow
        int INF = 100000000; 
        Arrays.fill(dp, INF);
        
        // Base case: cost to get 0 kg is 0
        dp[0] = 0; 
        
        // Iterate through all packet sizes
        for (int j = 1; j <= n; j++) {
            int currentCost = cost[j - 1];
            
            // Skip if the packet is unavailable
            if (currentCost == -1) {
                continue;
            }
            
            // Update the dp array for all weights from 'j' to 'w'
            for (int i = j; i <= w; i++) {
                if (dp[i - j] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - j] + currentCost);
                }
            }
        }
        
        // If dp[w] is still INF, it's impossible to fill the bag
        return dp[w] == INF ? -1 : dp[w];
    }
}