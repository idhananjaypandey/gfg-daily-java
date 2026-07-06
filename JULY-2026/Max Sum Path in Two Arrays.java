// Max Sum Path in Two Arrays

class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int i = 0, j = 0;
        int m = a.length, n = b.length;
        
        int sumA = 0;
        int sumB = 0;
        int totalSum = 0;
        
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                sumA += a[i];
                i++;
            } else if (b[j] < a[i]) {
                sumB += b[j];
                j++;
            } else {
                totalSum += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }
        
        while (i < m) {
            sumA += a[i];
            i++;
        }
        
        while (j < n) {
            sumB += b[j];
            j++;
        }
        
        totalSum += Math.max(sumA, sumB);
        
        return totalSum;
    }
}