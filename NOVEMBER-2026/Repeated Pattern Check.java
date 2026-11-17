class Solution {
    public boolean findPattern(String s) {
        int i = 0;
        int n = s.length();
        
        while (i < n) {
            int countX = 0;
            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }
            
            int countY = 0;
            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }
            
            if (countX == 0 || countX != countY) {
                return false;
            }
        }
        
        return true;
    }
}