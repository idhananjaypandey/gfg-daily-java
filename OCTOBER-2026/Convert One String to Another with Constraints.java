// Convert One String to Another with Constraints

class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int n = s1.length();
        int i = 0, j = 0;
        
        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }
            while (j < n && s2.charAt(j) == '#') {
                j++;
            }
            
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n) {
                return false;
            }
            
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            
            if (s1.charAt(i) == 'A' && i < j) {
                return false;
            }
            if (s1.charAt(i) == 'B' && i > j) {
                return false;
            }
            
            i++;
            j++;
        }
        
        while (i < n) {
            if (s1.charAt(i) != '#') {
                return false;
            }
            i++;
        }
        
        while (j < n) {
            if (s2.charAt(j) != '#') {
                return false;
            }
            j++;
        }
        
        return true;
    }
}