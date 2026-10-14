// Roll Characters of String

class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] count = new int[n + 1];

        // Record the frequency of rolls using a difference array concept
        // A roll of size r affects all indices from 0 to r-1
        for (int r : roll) {
            count[r]++;
        }

        // Compute the suffix sums of counts from right to left.
        // This ensures that an operation of size r affects all indices < r.
        int totalRolls = 0;
        int[] actualRolls = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            totalRolls += count[i + 1];
            actualRolls[i] = totalRolls;
        }

        // Build the final string
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int shifts = actualRolls[i] % 26;
            char originalChar = sb.charAt(i);
            char newChar = (char) ('a' + (originalChar - 'a' + shifts) % 26);
            sb.setCharAt(i, newChar);
        }

        return sb.toString();
    }
}