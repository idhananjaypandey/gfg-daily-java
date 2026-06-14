// Exit Point in a Matrix

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Direction vectors for: Right (0), Down (1), Left (2), Up (3)
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};
        
        int r = 0, c = 0;
        int dir = 0; // Start pointing Right
        
        // Track the last valid position before stepping out of bounds
        int lastRow = 0, lastCol = 0;
        
        while (r >= 0 && r < n && c >= 0 && c < m) {
            lastRow = r;
            lastCol = c;
            
            if (mat[r][c] == 1) {
                mat[r][c] = 0;        // Flip the 1 to 0
                dir = (dir + 1) % 4;  // Clockwise turn
            }
            
            // Move to the next cell
            r += dRow[dir];
            c += dCol[dir];
        }
        
        // Package the result into a List<Integer>
        List<Integer> ans = new ArrayList<>();
        ans.add(lastRow);
        ans.add(lastCol);
        
        return ans;
    }
}