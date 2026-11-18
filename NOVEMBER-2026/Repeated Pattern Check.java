// Repeated Pattern Check

class Solution {
    public boolean findPattern(String s) {
        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                if (yCount > 0) {
                    if (xCount != yCount) {
                        return false;
                    }
                    xCount = 0;
                    yCount = 0;
                }
                xCount++;
            } else {
                yCount++;
            }
        }
        return xCount == yCount;
    }
}