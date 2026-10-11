// Sort Two Parts Sorted

import java.util.Arrays;

class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakIndex = -1;
        
        // Step 1: Find the break point where sorting order violates
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                breakIndex = i;
                break;
            }
        }
        
        // If no break point found, array is already sorted
        if (breakIndex == -1) {
            return;
        }
        
        // Step 2: Merge the two sorted parts using a temporary array
        int[] temp = new int[n];
        int i = 0;                  // Pointer for first part (0 to breakIndex)
        int j = breakIndex + 1;     // Pointer for second part (breakIndex + 1 to n - 1)
        int k = 0;                  // Pointer for temp array
        
        while (i <= breakIndex && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // Copy remaining elements from the first part, if any
        while (i <= breakIndex) {
            temp[k++] = arr[i++];
        }
        
        // Copy remaining elements from the second part, if any
        while (j < n) {
            temp[k++] = arr[j++];
        }
        
        // Step 3: Copy sorted elements back to the original array
        System.arraycopy(temp, 0, arr, 0, n);
    }
}