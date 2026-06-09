// Seating Arrangement

class Solution {
    public static boolean canSeatAllPeople(int k, int[] seats) {
        int n = seats.length;
        
        // Step 1: Pre-validate the initial array for existing adjacent occupied seats
        for (int i = 0; i < n - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return false; 
            }
        }
        
        // Step 2: Try to seat the k people greedily
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                // Check if left and right neighbors are empty
                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
                boolean rightEmpty = (i == n - 1 || seats[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    seats[i] = 1; // Sit the person here
                    count++;
                    
                    // If we've successfully seated all k people, we can stop early
                    if (count >= k) {
                        return true;
                    }
                }
            }
        }
        
        return count >= k;
    }
}