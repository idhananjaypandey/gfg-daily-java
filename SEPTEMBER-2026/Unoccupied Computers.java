// Unoccupied Computers

class Solution {
    public int solve(int n, String s) {
        int[] status = new int[26]; // 0: Not seen, 1: Occupied computer, 2: Rejected
        int unattendedCount = 0;
        int available = n;

        for (int i = 0; i < s.length(); i++) {
            int customer = s.charAt(i) - 'A';

            if (status[customer] == 0) {
                // First arrival
                if (available > 0) {
                    available--;
                    status[customer] = 1; // Occupied
                } else {
                    status[customer] = 2; // Rejected
                    unattendedCount++;
                }
            } else if (status[customer] == 1) {
                // Departure after using a computer
                available++;
                status[customer] = 0;
            }
            // If status[customer] == 2 (rejected customer departing), no computer to free
        }

        return unattendedCount;
    }
}