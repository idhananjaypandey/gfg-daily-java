// Substring with Max Zero-One Diff

class Solution {
    int maxSubstring(String s) {
        int max_so_far = -1;
        int current_max = 0;
        
        // Loop through each character in the binary string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Map '0' to +1 and '1' to -1
            int val = (ch == '0') ? 1 : -1;
            
            // Add value to the running substring sum
            current_max += val;
            
            // Track the maximum difference seen so far
            if (current_max > max_so_far) {
                max_so_far = current_max;
            }
            
            // If the running sum drops below 0, reset it
            if (current_max < 0) {
                current_max = 0;
            }
        }
        
        return max_so_far;
    }
}