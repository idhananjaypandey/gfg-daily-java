// Largest Subsquare Surrounded by X

class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        int[][] ver = new int[n][n];
        int[][] hor = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
                    hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
                } else {
                    ver[i][j] = 0;
                    hor[i][j] = 0;
                }
            }
        }

        int maxSize = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int small = Math.min(ver[i][j], hor[i][j]);

                while (small > maxSize) {
                    if (ver[i][j - small + 1] >= small && hor[i - small + 1][j] >= small) {
                        maxSize = small;
                        break;
                    }
                    small--;
                }
            }
        }

        return maxSize;
    }
}