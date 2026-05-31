class Solution {
    public static boolean isSumOfConsecutive(int n) {
        // 1 cannot be expressed as the sum of two or more consecutive positive numbers
        if (n <= 1) {
            return false;
        }
        
        // If n is a power of 2, (n & (n - 1)) will be 0.
        // We return true if it is NOT a power of 2.
        return (n & (n - 1)) != 0;
    }
}