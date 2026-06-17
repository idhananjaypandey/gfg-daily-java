// Cut rope to maximise product

class Solution {
    public long maxProduct(int n) {
        // Base cases where mandatory cut forces smaller products
        if (n == 2) return 1;
        if (n == 3) return 2;

        long result = 1;

        // Greedily multiply by 3 until n is 4 or less
        while (n > 4) {
            result *= 3;
            n -= 3;
        }

        // Multiply the remaining piece (which will be 2, 3, or 4)
        return result * n;
    }
}