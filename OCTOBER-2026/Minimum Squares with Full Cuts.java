// Minimum Squares with Full Cuts

class Solution {
    public int minSquares(int n, int m) {
        int count = 0;

        while (n > 0 && m > 0) {
            if (n == m) {
                count += 1;
                break;
            }

            // Ensure n is the smaller dimension and m is the larger dimension
            if (n > m) {
                int temp = n;
                n = m;
                m = temp;
            }

            // Cut out as many squares of size n x n as can fit in the dimension m
            int squares = m / n;
            count += squares;

            // The remaining length along the longer side
            m = m % n;
        }

        return count;
    }
}