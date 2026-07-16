// Numbers with Given Digit Sum

class Solution {
    public int countWays(int n, int sum) {
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }

        if (n == 1) {
            return (sum >= 1 && sum <= 9) ? 1 : -1;
        }

        int[][] dp = new int[n][sum + 1];

        for (int j = 0; j <= Math.min(9, sum); j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= sum; j++) {
                for (int digit = 0; digit <= 9; digit++) {
                    if (j - digit >= 0) {
                        dp[i][j] += dp[i - 1][j - digit];
                    }
                }
            }
        }

        int totalCount = 0;
        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            if (sum - firstDigit >= 0) {
                totalCount += dp[n - 2][sum - firstDigit];
            }
        }

        return totalCount == 0 ? -1 : totalCount;
    }
}