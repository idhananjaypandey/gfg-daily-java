// Snake and Ladder Problem

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;
        int[] move = new int[target + 1];

        // Default: each cell maps to itself
        for (int i = 1; i <= target; i++) {
            move[i] = i;
        }

        // Map ladders: start -> end
        for (int i = 0; i < lad.length; i += 2) {
            move[lad[i]] = lad[i + 1];
        }

        // Map snakes: start -> end
        for (int i = 0; i < sn.length; i += 2) {
            move[sn[i]] = sn[i + 1];
        }

        // BFS setup
        boolean[] visited = new boolean[target + 1];
        Queue<int[]> queue = new LinkedList<>(); // store pairs of {cell, throws}

        // Start at cell 1 with 0 throws
        visited[1] = true;
        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cell = curr[0];
            int dist = curr[1];

            if (cell == target) {
                return dist;
            }

            // Roll dice from 1 to 6
            for (int die = 1; die <= 6; die++) {
                int next = cell + die;

                if (next <= target) {
                    int destination = move[next];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.add(new int[]{destination, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}