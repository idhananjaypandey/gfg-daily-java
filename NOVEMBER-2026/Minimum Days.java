class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int count = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            }
        }
        
        if (count == 0) {
            return 0;
        }
        
        for (int i = 0; i < n; i++) {
            int idx = p[i];
            
            if (idx > 0 && arr[idx] == arr[idx - 1]) {
                count--;
            }
            if (idx < n - 1 && arr[idx] == arr[idx + 1]) {
                count--;
            }
            
            arr[idx] = '?';
            
            if (count == 0) {
                return i + 1;
            }
        }
        
        return 0;
    }
}