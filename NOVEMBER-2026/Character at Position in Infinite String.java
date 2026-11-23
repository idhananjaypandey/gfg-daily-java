class Solution {
    public char posInfinite(String s, int pos) {
        long n = s.length();
        long p = pos;

        if (p <= n) {
            return s.charAt((int) p - 1);
        }

        long len = n;
        long i = 1;
        while (len < p) {
            len = 2 * len + i;
            i++;
        }

        i--;
        while (i >= 1) {
            long prevLen = (len - i) / 2;

            if (p <= prevLen) {
                len = prevLen;
            } else if (p <= prevLen + i) {
                return '$';
            } else {
                long offsetInRev = p - (prevLen + i);
                p = prevLen - offsetInRev + 1;
                len = prevLen;
            }
            i--;
        }

        return s.charAt((int) p - 1);
    }
}