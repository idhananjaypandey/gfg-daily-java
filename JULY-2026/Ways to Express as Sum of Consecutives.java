// Ways to Express as Sum of Consecutives

class Solution {
    public int getCount(int n) {
        int count = 0;
        int L = 2;
        while (true) {
            int numerator = n - (L * (L - 1)) / 2;
            if (numerator <= 0) {
                break;
            }
            if (numerator % L == 0) {
                count++;
            }
            L++;
        }
        return count;
    }
}