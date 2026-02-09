class Solution {
    public int findKRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Binary search to find the index of the minimum element
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than high element, 
            // the pivot/min is in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } 
            // Otherwise, the pivot/min is in the left half (including mid)
            else {
                high = mid;
            }
        }

        // The index 'low' will point to the minimum element
        return low;
    }
}
