// Longest Possible Route in a Matrix with Hurdles

class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        
        return findLongestPath(mat, xs, ys, xd, yd, visited);
    }
    
    private int findLongestPath(int[][] mat, int r, int c, int xd, int yd, boolean[][] visited) {
        if (r == xd && c == yd) {
            return 0;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        visited[r][c] = true;
        int maxPath = -1;
        
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nextRow = r + rowOffsets[i];
            int nextCol = c + colOffsets[i];
            
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m 
                && mat[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                
                int res = findLongestPath(mat, nextRow, nextCol, xd, yd, visited);
                
                if (res != -1) {
                    maxPath = Math.max(maxPath, 1 + res);
                }
            }
        }
        
        visited[r][c] = false;
        
        return maxPath;
    }
}