// Nth in Concatenated Decimal String

class Solution {
    public char nthCharacter(int n) {
        long len = 1;
        long count = 9;
        long start = 1;

        while (n > len * count) {
            n -= (int)(len * count);
            len++;
            count *= 10;
            start *= 10;
        }

        long numberIndex = (n - 1) / len;
        long targetNumber = start + numberIndex;
        int digitIndex = (int)((n - 1) % len);

        return Long.toString(targetNumber).charAt(digitIndex);
    }
}