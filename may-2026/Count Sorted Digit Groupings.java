class Solution {

    // Static variable to store dynamic programming results
    static int[][] gp;

    // Method to calculate the total count based on the given string
    public int validGroups(String str) {

        // Calculating the sum of digits in the string
        int sm = calculateSum(str);

        // Initializing the dynamic programming array
        initializegp(str.length() + 1, sm);

        // Invoking the solve method to compute the total count
        return solve(0, 0, str.length(), str);
    }

    // Method to calculate the sum of digits in a string
    static int calculateSum(String str) {
        int sm = 0;

        for (char digit : str.toCharArray()) {
            sm += digit - '0';
        }

        return sm;
    }

    // Method to initialize the dynamic programming array with -1 values
    static void initializegp(int rows, int cols) {

        gp = new int[rows][cols + 1];

        for (int[] row : gp) {
            Arrays.fill(row, -1);
        }
    }

    // Recursive method to solve the problem and memoize results
    static int solve(int cp, int cs, int sz, String s) {

        // Base case
        if (cp == sz) {
            return 1;
        }

        // If already calculated
        if (gp[cp][cs] != -1) {
            return gp[cp][cs];
        }

        int sm = 0;
        int cnt = 0;

        // Try all possible groups
        for (int i = cp; i < sz; i++) {

            sm += s.charAt(i) - '0';

            if (sm >= cs) {
                cnt += solve(i + 1, sm, sz, s);
            }
        }

        // Store and return answer
        return gp[cp][cs] = cnt;
    }
}