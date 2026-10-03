// Coils in Matrix

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int size = 4 * n;
        int total = size * size / 2;

        int[][] matrix = new int[size][size];

        int value = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = value++;
            }
        }

        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();

        boolean[][] visited = new boolean[size][size];

        int[] dr1 = {1, 0, -1, 0};
        int[] dc1 = {0, 1, 0, -1};

        int[] dr2 = {-1, 0, 1, 0};
        int[] dc2 = {0, -1, 0, 1};

        int r1 = 0, c1 = 0;
        int r2 = size - 1, c2 = size - 1;

        int d1 = 0;
        int d2 = 0;

        for (int k = 0; k < total; k++) {
            coil1.add(matrix[r1][c1]);
            visited[r1][c1] = true;

            coil2.add(matrix[r2][c2]);
            visited[r2][c2] = true;

            int nr1 = r1 + dr1[d1];
            int nc1 = c1 + dc1[d1];

            if (nr1 < 0 || nr1 >= size || nc1 < 0 || nc1 >= size || visited[nr1][nc1]) {
                d1 = (d1 + 1) % 4;
                nr1 = r1 + dr1[d1];
                nc1 = c1 + dc1[d1];
            }

            int nr2 = r2 + dr2[d2];
            int nc2 = c2 + dc2[d2];

            if (nr2 < 0 || nr2 >= size || nc2 < 0 || nc2 >= size || visited[nr2][nc2]) {
                d2 = (d2 + 1) % 4;
                nr2 = r2 + dr2[d2];
                nc2 = c2 + dc2[d2];
            }

            r1 = nr1;
            c1 = nc1;

            r2 = nr2;
            c2 = nc2;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(coil1);
        result.add(coil2);

        return result;
    }
}