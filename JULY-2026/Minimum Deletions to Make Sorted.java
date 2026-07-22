// Minimum Deletions to Make Sorted

class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        
        int[] tail = new int[n];
        int len = 0;
        
        for (int x : arr) {
            // Binary search to find the first element in tail >= x
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            tail[left] = x;
            if (left == len) {
                len++;
            }
        }
        
        return n - len;
    }
}