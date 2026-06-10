// Binary Searchable Count

class Solution {
    public static int binarySearchable(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // For each element, we need to know:
        // 1. Is there any element to its right that is greater than ALL elements further right?
        // Let's use a simpler, clean tracking approach:
        
        int searchableCount = 0;

        // Check each element individually against the true binary search constraints
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int l = 0, r = n - 1;
            boolean found = false;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] == target) {
                    found = true;
                    break;
                } else if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (found) {
                searchableCount++;
            }
        }

        return searchableCount;
    }
}