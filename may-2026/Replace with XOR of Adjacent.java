// Replace with XOR of Adjacent

class Solution {
    
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n < 2) return; // Guard clause based on constraints (though n >= 2)

        // Store the original first element before we overwrite it
        int prev = arr[0];
        
        // 1. Update the first element
        arr[0] = arr[0] ^ arr[1];
        
        // 2. Update the middle elements
        for (int i = 1; i < n - 1; i++) {
            int currentOriginal = arr[i]; // Remember original arr[i] for next iteration
            
            // arr[i] = (original arr[i-1]) ^ arr[i+1]
            arr[i] = prev ^ arr[i + 1]; 
            
            prev = currentOriginal; // Update prev to be the original arr[i]
        }
        
        // 3. Update the last element (using the original arr[n-2] stored in prev)
        arr[n - 1] = prev ^ arr[n - 1];
    }
}