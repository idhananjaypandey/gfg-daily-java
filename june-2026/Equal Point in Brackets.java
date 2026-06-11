// Equal Point in Brackets

class Solution {
    public int findIndex(String s) {
    int totalClose = 0;
        
        // Count the total number of closing brackets in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                totalClose++;
            }
        }
        
        // The index k is simply equal to the total count of ')'
        return totalClose;
    }
}