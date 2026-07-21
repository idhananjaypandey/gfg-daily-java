// Maximum Reachable Index Difference

class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int start = -1;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                start = i;
                break;
            }
        }
        
        if (start == -1) {
            return -1;
        }
        
        int maxDiff = 0;
        int currPos = start;
        
        for (char ch = 'b'; ch <= 'z'; ch++) {
            int lastIdx = -1;
            int firstIdx = -1;
            
            for (int i = currPos + 1; i < n; i++) {
                if (s.charAt(i) == ch) {
                    if (firstIdx == -1) {
                        firstIdx = i;
                    }
                    lastIdx = i;
                }
            }
            
            if (lastIdx != -1) {
                maxDiff = Math.max(maxDiff, lastIdx - start);
            }
            
            if (firstIdx != -1) {
                currPos = firstIdx;
            } else {
                break;
            }
        }
        
        return maxDiff;
    }
}