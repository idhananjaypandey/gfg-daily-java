// Subsets with Products of Distinct Primes

class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] freq = new int[31];

        for (int x : arr) freq[x]++;

        int[] mask = new int[31];
        Arrays.fill(mask, -1);

        for (int i = 2; i <= 30; i++) {
            int x = i;
            int m = 0;
            boolean ok = true;
            for (int j = 0; j < primes.length; j++) {
                int p = primes[j];
                int c = 0;
                while (x % p == 0) {
                    x /= p;
                    c++;
                }
                if (c > 1) {
                    ok = false;
                    break;
                }
                if (c == 1) m |= (1 << j);
            }
            if (ok) mask[i] = m;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int v = 2; v <= 30; v++) {
            if (freq[v] == 0 || mask[v] == -1) continue;
            long[] ndp = dp.clone();
            int m = mask[v];
            for (int s = 0; s < (1 << 10); s++) {
                if ((s & m) == 0) {
                    int ns = s | m;
                    ndp[ns] = (ndp[ns] + dp[s] * freq[v]) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int s = 1; s < (1 << 10); s++) {
            ans = (ans + dp[s]) % MOD;
        }

        long pow = 1;
        long base = 2;
        int e = freq[1];
        while (e > 0) {
            if ((e & 1) == 1) pow = (pow * base) % MOD;
            base = (base * base) % MOD;
            e >>= 1;
        }

        ans = (ans * pow) % MOD;
        return (int) ans;
    }
}