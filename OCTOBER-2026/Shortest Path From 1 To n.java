// Shortest Path From 1 To n

class Solution {
    public int minimumStep(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n -= 1;
            }
            count++;
        }
        return count;
    }
}