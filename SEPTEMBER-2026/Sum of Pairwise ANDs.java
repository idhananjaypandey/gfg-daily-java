// Sum of Pairwise ANDs

class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;

        for (int k = 0; k < 32; k++) {
            long kCount = 0;

            for (int num : arr) {
                if ((num & (1 << k)) != 0) {
                    kCount++;
                }
            }

            long pairs = (kCount * (kCount - 1)) / 2;
            totalSum += pairs * (1L << k);
        }

        return totalSum;
    }
}