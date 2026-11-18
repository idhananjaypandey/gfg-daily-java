class Solution {
    private static int xorUpto(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }

    public static int findXOR(int l, int r) {
        return xorUpto(l - 1) ^ xorUpto(r);
    }
}