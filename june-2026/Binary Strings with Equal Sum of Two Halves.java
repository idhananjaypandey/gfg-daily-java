// Binary Strings with Equal Sum of Two Halves

class Solution {
    private static final int MOD = 1000000007;

    public int compute_value(int n) {
        if (n == 0) return 1;

        // We need (2n)! / (n! * n!) % MOD
        long numerator = 1;
        long denominator = 1;

        // Calculate (2n)! and n! in a single loop to save time
        for (int i = 1; i <= n; i++) {
            denominator = (denominator * i) % MOD;
        }
        
        // numerator will hold (2n)!
        for (int i = 1; i <= 2 * n; i++) {
            numerator = (numerator * i) % MOD;
        }

        // Compute modular inverse of (n!)
        long invDenom = power(denominator, MOD - 2);

        // Result = (2n)! * invDenom * invDenom % MOD
        long ans = (numerator * invDenom) % MOD;
        ans = (ans * invDenom) % MOD;

        return (int) ans;
    }

    // Modular exponentiation to find (base^exp) % MOD
    private long power(long base, long exp) {
        long res = 1;
        base = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}