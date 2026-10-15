// Maximum Without 3 Consecutive Set Bits

class Solution {
    public int maxValue(int n) {
        for (int i = 31; i >= 2; i--) {
            if (((n >> i) & 1) == 1 && ((n >> (i - 1)) & 1) == 1 && ((n >> (i - 2)) & 1) == 1) {
                n ^= (1 << (i - 2));
            }
        }
        return n;
    }
}