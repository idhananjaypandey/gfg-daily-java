// Values with Equal Array Remainders

class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;
        if (n <= 1) return -1;

        int g = 0;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            g = gcd(g, diff);
        }

        if (g == 0) {
            return -1;
        }

        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++;
                if (i * i != g) {
                    count++;
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