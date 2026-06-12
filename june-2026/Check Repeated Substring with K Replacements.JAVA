// Check Repeated Substring with K Replacements

class Solution {
  public boolean kSubstr(String s, int k) {
        int n = s.length();
        
        // If string length is not divisible by k, we cannot partition it
        if (n % k != 0) return false;
        
        int numSegments = n / k;
        
        // Map to store frequency of each unique segment of length k
        Map<String, Integer> segmentCount = new HashMap<>();
        
        for (int i = 0; i < n; i += k) {
            String segment = s.substring(i, i + k);
            segmentCount.put(segment, segmentCount.getOrDefault(segment, 0) + 1);
        }
        
        // Case 1: All segments are already the same
        if (segmentCount.size() == 1) return true;
        
        // Case 2: Only two types of segments exist
        if (segmentCount.size() == 2) {
            // Check if one of the segments appears exactly once
            for (int count : segmentCount.values()) {
                if (count == 1) return true;
            }
        }
        
        // Otherwise, it's impossible to fix with only one replacement
        return false;
    }
}