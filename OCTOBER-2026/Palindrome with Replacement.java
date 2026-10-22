// Palindrome with Replacement

class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (arr[i] != '?' && arr[j] != '?') {
                if (arr[i] != arr[j]) return -1;
            } else if (arr[i] != '?') {
                arr[j] = arr[i];
            } else if (arr[j] != '?') {
                arr[i] = arr[j];
            }
        }
        
        char prev = 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != '?') {
                if (prev != 0) {
                    sum += Math.abs(arr[i] - prev);
                }
                prev = arr[i];
            }
        }
        
        if (prev == 0) return 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                arr[i] = prev;
            } else {
                prev = arr[i];
            }
        }
        
        return sum;
    }
}