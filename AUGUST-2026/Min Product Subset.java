// Min Product Subset

class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int countNeg = 0;
        int countZero = 0;
        int prod = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }

            if (arr[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, arr[i]);
            } else {
                minPos = Math.min(minPos, arr[i]);
            }

            prod *= arr[i];
        }

        // Case 1: If there are no negative numbers
        if (countNeg == 0) {
            if (countZero > 0) return 0;
            return minPos;
        }

        // Case 2: If count of negative numbers is even
        if (countNeg % 2 == 0) {
            prod /= maxNeg;
        }

        return prod;
    }
}