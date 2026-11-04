class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        if (n % 2 == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            res ^= arr[i];
        }
        return res;
    }
}