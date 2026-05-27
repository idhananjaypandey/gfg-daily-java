// Wifi Range

class Solution {
    public static boolean wifiRange(String s, int x) {
        int n = s.length();
        // Tracks the furthest index currently covered by WiFi
        int lastCovered = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // Check if there is an uncovered gap before this router
                if (i - x > lastCovered + 1) {
                    return false;
                }
                // Update the furthest covered index
                lastCovered = Math.max(lastCovered, i + x);
            }
        }

        // Verify if the coverage reaches the very last room
        return lastCovered >= n - 1;
    }
}