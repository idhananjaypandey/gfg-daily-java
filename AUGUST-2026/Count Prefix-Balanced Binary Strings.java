// Count Prefix-Balanced Binary Strings

class Solution {
    public int prefixStrings(int n) {
        long MOD = 1000000007;
        long numerator = 1;
        long denominator = 1;
        
        for (int i = 1; i <= n; i++) {
            numerator = (numerator * (n + i)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        
        denominator = (denominator * (n + 1)) % MOD;
        
        return (int) ((numerator * modInverse(denominator, MOD)) % MOD);
    }
    
    private long modInverse(long base, long mod) {
        return power(base, mod - 2, mod);
    }
    
    private long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        
        return res;
    }
}