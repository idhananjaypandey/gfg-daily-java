// Subarray Frequency Count Queries

class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // Map to store the positions/indices of each element
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            posMap.putIfAbsent(arr[i], new ArrayList<>());
            posMap.get(arr[i]).add(i);
        }
        
        // Return type must match the signature exactly
        ArrayList<Integer> result = new ArrayList<>();
        
        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            
            // If the element x doesn't exist in the array at all
            if (!posMap.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            List<Integer> indices = posMap.get(x);
            
            // Find the count of indices that fall within [l, r]
            int count = countInRange(indices, l, r);
            result.add(count);
        }
        
        return result;
    }
    
    private int countInRange(List<Integer> indices, int l, int r) {
        // Find the index of the first element >= l
        int leftIdx = upperBound(indices, l - 1);
        // Find the index of the first element > r
        int rightIdx = upperBound(indices, r);
        
        return rightIdx - leftIdx;
    }
    
    // Standard Upper Bound binary search implementation
    // Returns the index of the first element strictly greater than key
    private int upperBound(List<Integer> list, int key) {
        int low = 0;
        int high = list.size();
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}