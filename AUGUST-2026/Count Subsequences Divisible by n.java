// Count Subsequences Divisible by n

class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;
        
        // dp[r] stores the number of subsequences with remainder r modulo n
        long[] dp = new long[n];
        
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            long[] nextDp = new long[n];
            
            // 1. Carry forward previous subsequences unchanged
            for (int r = 0; r < n; r++) {
                nextDp[r] = dp[r];
            }
            
            // 2. Append current digit to existing subsequences
            for (int r = 0; r < n; r++) {
                if (dp[r] > 0) {
                    int newRem = (r * 10 + digit) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[r]) % MOD;
                }
            }
            
            // 3. Start a new subsequence using only the current digit
            int singleDigitRem = digit % n;
            nextDp[singleDigitRem] = (nextDp[singleDigitRem] + 1) % MOD;
            
            dp = nextDp;
        }
        
        // Return number of non-empty subsequences divisible by n (remainder 0)
        return (int) dp[0];
    }
}