// Largest Rectangle with Column Swaps

class Solution {
     public int maxArea(int[][] mat) {
         int n = mat.length;
         int m = mat[0].length;

         // Auxiliary matrix to store height of consecutive 1s ending at mat[i][j]
         int[][] hist = new int[n][m];

         // Step 1: Fill the height matrix
         for (int j = 0; j < m; j++) {
             hist[0][j] = mat[0][j];
             for (int i = 1; i < n; i++) {
                 hist[i][j] = (mat[i][j] == 0) ? 0 : hist[i - 1][j] + 1;
             }
         }

         int maxArea = 0;

         // Step 2 & 3: Sort each row and calculate max area
         for (int i = 0; i < n; i++) {
             // Copy row to sort (or sort in-place since we process row-by-row)
             Arrays.sort(hist[i]);

             // Calculate max area for row i
             for (int j = 0; j < m; j++) {
                 int height = hist[i][j];
                 int width = m - j; // Number of columns with height >= hist[i][j]
                 maxArea = Math.max(maxArea, height * width);
             }
         }

         return maxArea;
     }
 }