// Word in Grid - All Occurrences

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == word.charAt(0) && searchFromCell(mat, word, r, c, dx, dy, n, m)) {
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(r);
                    pos.add(c);
                    result.add(pos);
                }
            }
        }
        
        return result;
    }

    private boolean searchFromCell(char[][] mat, String word, int r, int c, int[] dx, int[] dy, int n, int m) {
        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int currR = r;
            int currC = c;
            int k;

            for (k = 0; k < len; k++) {
                if (currR < 0 || currR >= n || currC < 0 || currC >= m) {
                    break;
                }
                
                if (mat[currR][currC] != word.charAt(k)) {
                    break;
                }

                currR += dx[dir];
                currC += dy[dir];
            }

            if (k == len) {
                return true;
            }
        }

        return false;
    }
}