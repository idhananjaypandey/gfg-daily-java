// Trace Path

class Solution {
    public boolean isPossible(int n, int m, String s) {
        int curX = 0, curY = 0;
        int minX = 0, maxX = 0;
        int minY = 0, maxY = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                curY--;
            } else if (ch == 'R') {
                curY++;
            } else if (ch == 'D') {
                curX--;
            } else if (ch == 'U') {
                curX++;
            }
            minX = Math.min(minX, curX);
            maxX = Math.max(maxX, curX);
            minY = Math.min(minY, curY);
            maxY = Math.max(maxY, curY);
        }
        
        int totalRows = maxX - minX + 1;
        int totalCols = maxY - minY + 1;
        
        return totalRows <= n && totalCols <= m;
    }
}