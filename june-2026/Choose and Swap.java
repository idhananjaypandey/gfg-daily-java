// Choose and Swap

class Solution {
    public String chooseSwap(String s) {
        // Track the first occurrence index of each character (-1 means not present)
        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstOccur[charIndex] == -1) {
                firstOccur[charIndex] = i;
            }
        }
        
        char charToReplace = ' ';
        char replacementChar = ' ';
        boolean found = false;
        
        // Traverse the string to find the first character that can be minimized
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // Look for any character smaller than 'ch' that appears after it
            for (char c = 'a'; c < ch; c++) {
                // If character 'c' exists in the string and its first occurrence 
                // is after the current position, we found our swap pair!
                if (firstOccur[c - 'a'] != -1 && firstOccur[c - 'a'] > i) {
                    charToReplace = ch;
                    replacementChar = c;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        // If a valid swap is found, perform the replacement for all occurrences
        if (found) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (arr[i] == charToReplace) {
                    arr[i] = replacementChar;
                } else if (arr[i] == replacementChar) {
                    arr[i] = charToReplace;
                }
            }
            return new String(arr);
        }
        
        return s;
    }
}