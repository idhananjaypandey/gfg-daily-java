// Count Pairs Divisible By K

class Solution {
    public int countKdivPairs(int[] arr, int k) {
        long[] freq = new long[k];
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            freq[rem]++;
        }
        
        long count = 0;
        count += (freq[0] * (freq[0] - 1)) / 2;
        
        for (int i = 1; i <= k / 2 && i != k - i; i++) {
            count += freq[i] * freq[k - i];
        }
        
        if (k % 2 == 0) {
            count += (freq[k / 2] * (freq[k / 2] - 1)) / 2;
        }
        
        return (int) count;
    }
}