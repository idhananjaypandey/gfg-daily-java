// Lexicographically smallest after removing k

import java.util.Stack;

class Solution {
    // Helper function to check if a number is a power of 2
    private static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        // Step 1: Correct the value of k
        if (isPowerOfTwo(n)) {
            k = k / 2;
        } else {
            k = k * 2;
        }

        // Step 2: Handle edge cases where removal is not possible or results in empty string
        if (k >= n || k < 0) {
            return "-1";
        }
        if (k == 0) {
            return s;
        }

        // Step 3: Build the lexicographically smallest string using a stack-like approach
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // While stack is not empty, current char is smaller than top of stack, and k > 0
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) > ch && k > 0) {
                stack.deleteCharAt(stack.length() - 1); // Pop
                k--;
            }
            stack.append(ch); // Push
        }

        // If we still need to remove characters, remove them from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        return stack.toString();
    }
}