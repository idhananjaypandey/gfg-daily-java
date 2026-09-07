// Minimum Elements Outside Subsequences

class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int maxVal = 101;
        
        int[][][] dp = new int[n + 1][maxVal + 1][maxVal + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxVal; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int maxPicked = solve(0, 0, maxVal, arr, dp);
        return n - maxPicked;
    }

    private int solve(int idx, int lastInc, int lastDec, int[] arr, int[][][] dp) {
        if (idx == arr.length) {
            return 0;
        }

        if (dp[idx][lastInc][lastDec] != -1) {
            return dp[idx][lastInc][lastDec];
        }

        int option1 = solve(idx + 1, lastInc, lastDec, arr, dp);
        int option2 = 0;
        int option3 = 0;

        if (arr[idx] > lastInc) {
            option2 = 1 + solve(idx + 1, arr[idx], lastDec, arr, dp);
        }

        if (arr[idx] < lastDec) {
            option3 = 1 + solve(idx + 1, lastInc, arr[idx], arr, dp);
        }

        return dp[idx][lastInc][lastDec] = Math.max(option1, Math.max(option2, option3));
    }
}