// Pairs with Given GCD and LCM

class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) {
            return 0;
        }

        int k = y / x;
        int count = 0;

        for (int i = 1; i * i <= k; i++) {
            if (k % i == 0) {
                int j = k / i;
                if (gcd(i, j) == 1) {
                    if (i == j) {
                        count += 1;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}