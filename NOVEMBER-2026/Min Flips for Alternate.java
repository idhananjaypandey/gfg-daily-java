class Solution {
    public int minFlips(String s) {
        int flipsStartingWithZero = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char expectedChar = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expectedChar) {
                flipsStartingWithZero++;
            }
        }
        
        int flipsStartingWithOne = n - flipsStartingWithZero;
        return Math.min(flipsStartingWithZero, flipsStartingWithOne);
    }
}