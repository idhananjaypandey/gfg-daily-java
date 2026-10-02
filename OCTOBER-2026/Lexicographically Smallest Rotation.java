// Lexicographically Smallest Rotation

class Solution {
    public String lexiString(String s) {
        String concat = s + s;
        int n = s.length();
        int i = 0, j = 1, k = 0;
        
        while (i < n && j < n && k < n) {
            char c1 = concat.charAt(i + k);
            char c2 = concat.charAt(j + k);
            
            if (c1 == c2) {
                k++;
            } else if (c1 > c2) {
                i = Math.max(i + k + 1, j + 1);
                k = 0;
            } else {
                j = Math.max(j + k + 1, i + 1);
                k = 0;
            }
        }
        
        int minStart = Math.min(i, j);
        return concat.substring(minStart, minStart + n);
    }
}