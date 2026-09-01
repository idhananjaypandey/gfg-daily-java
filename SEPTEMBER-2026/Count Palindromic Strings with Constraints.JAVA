// Count Palindromic Strings with Constraints

class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007;
        long totalCount = 0;

        for (int L = 1; L <= n; L++) {
            int m = (L + 1) / 2; // Ceiling of L / 2
            
            if (m > k) {
                continue; // Impossible to pick m distinct characters
            }
            
            // Calculate P(k, m) % MOD
            long choices = 1;
            for (int i = 0; i < m; i++) {
                choices = (choices * (k - i)) % MOD;
            }
            
            totalCount = (totalCount + choices) % MOD;
        }

        return (int) totalCount;
    }
}