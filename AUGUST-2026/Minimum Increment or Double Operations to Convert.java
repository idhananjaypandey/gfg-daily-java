// Minimum Increment or Double Operations to Convert

class Solution {
    public int countMinOperations(int[] arr) {
        int totalIncrements = 0;
        int maxBitLength = 0;

        for (int num : arr) {
            int count = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    totalIncrements++;
                }
                num >>= 1;
                count++;
            }
            if (count > maxBitLength) {
                maxBitLength = count;
            }
        }

        int maxDoubles = (maxBitLength > 0) ? maxBitLength - 1 : 0;

        return totalIncrements + maxDoubles;
    }
}