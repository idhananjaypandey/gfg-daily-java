import java.util.Arrays;

class Solution {
    public int findKthSmall(int[] arr, int k) {
        // Sort the array in-place (O(1) auxiliary space)
        Arrays.sort(arr);
        
        // For every element <= k, the k-th missing number shifts right by 1
        for (int num : arr) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        
        return k;
    }
}