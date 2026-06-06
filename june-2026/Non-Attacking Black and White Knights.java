// Non-Attacking Black and White Knights

class Solution {
    public static long numOfWays(int n, int m) {
        long totalSquares = (long) n * m;
        
        // Total ways to place two distinct knights without restrictions
        long totalWays = totalSquares * (totalSquares - 1);
        
        long attackingWays = 0;
        
        // Count attacking configurations in 2x3 sub-grids
        if (n >= 2 && m >= 3) {
            attackingWays += 4L * (n - 1) * (m - 2);
        }
        
        // Count attacking configurations in 3x2 sub-grids
        if (n >= 3 && m >= 2) {
            attackingWays += 4L * (n - 2) * (m - 1);
        }
        
        // Valid ways = Total arrangements - Attacking arrangements
        return totalWays - attackingWays;
    }
}