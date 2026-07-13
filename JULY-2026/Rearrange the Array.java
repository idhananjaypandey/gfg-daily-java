// Rearrange the Array

class Solution {
    int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n + 1];
        List<Integer> cycleLengths = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int count = 0;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr - 1];
                    count++;
                }
                cycleLengths.add(count);
            }
        }

        Map<Integer, Integer> maxPrimePowers = new HashMap<>();
        for (int len : cycleLengths) {
            Map<Integer, Integer> factors = getPrimeFactors(len);
            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
                int prime = entry.getKey();
                int exponent = entry.getValue();
                maxPrimePowers.put(prime, Math.max(maxPrimePowers.getOrDefault(prime, 0), exponent));
            }
        }

        long ans = 1;
        long mod = 1000000007;
        for (Map.Entry<Integer, Integer> entry : maxPrimePowers.entrySet()) {
            ans = (ans * power(entry.getKey(), entry.getValue(), mod)) % mod;
        }

        return (int) ans;
    }

    private Map<Integer, Integer> getPrimeFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) factors.put(n, factors.getOrDefault(n, 0) + 1);
        return factors;
    }

    private long power(long base, int exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}